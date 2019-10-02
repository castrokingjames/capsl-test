package cc.capsl.esports.data.repository

import cc.capsl.esports.data.GameData
import cc.capsl.esports.data.store.GameDataStore
import cc.capsl.esports.domain.Game
import cc.capsl.esports.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GameDataRepository(private val gameDataStoreFactory: GameDataStore.Factory) : GameRepository {

    override suspend fun load(): Flow<List<Game>> {
        return flow {
            loadFromLocal()
                    .ifEmpty {
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                    }
                    .map {
                        Game(it.id, it.name, it.image)
                    }
                    .apply {
                        emit(this)
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                                .map {
                                    Game(it.id, it.name, it.image)
                                }
                                .apply {
                                    emit(this)
                                }
                    }
        }
    }

    private suspend fun loadFromNetwork(): List<GameData> {
        val remote = gameDataStoreFactory.createRemoteDataStore()
        return remote.load()
    }

    private suspend fun loadFromLocal(): List<GameData> {
        val local = gameDataStoreFactory.createLocalDataStore()
        return local.load()
    }

    private suspend fun saveToLocal(games: List<GameData>) {
        val local = gameDataStoreFactory.createLocalDataStore()
        local.save(games)
    }
}