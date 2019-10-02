package cc.capsl.esports.data.repository

import cc.capsl.esports.data.StageData
import cc.capsl.esports.data.store.StageDataStore
import cc.capsl.esports.domain.Stage
import cc.capsl.esports.domain.repository.StageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StageDataRepository(private val stageDataStoreFactory: StageDataStore.Factory) : StageRepository {

    override suspend fun load(): Flow<List<Stage>> {
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
                        Stage(it.id, it.name, it.active)
                    }
                    .apply {
                        emit(this)
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                                .map {
                                    Stage(it.id, it.name, it.active)
                                }
                                .apply {
                                    emit(this)
                                }
                    }
        }
    }

    private suspend fun loadFromNetwork(): List<StageData> {
        val remote = stageDataStoreFactory.createRemoteDataStore()
        return remote.load()
    }

    private suspend fun loadFromLocal(): List<StageData> {
        val local = stageDataStoreFactory.createLocalDataStore()
        return local.load()
    }

    private suspend fun saveToLocal(games: List<StageData>) {
        val local = stageDataStoreFactory.createLocalDataStore()
        local.save(games)
    }
}