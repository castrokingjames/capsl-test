package cc.capsl.esports.data.remote.store

import cc.capsl.esports.data.GameData
import cc.capsl.esports.data.remote.service.GameService
import cc.capsl.esports.data.store.GameDataStore

class RemoteGameDataStore(private val service: GameService) : GameDataStore {

    override suspend fun load(): List<GameData> {
        return service
                .loadGames()
                .let { response ->
                    response
                            .results
                            ?.map {
                                GameData(it.id, it.name, it.image)
                            }
                }
    }

    override suspend fun save(games: List<GameData>) {
        throw UnsupportedOperationException("Can't save to remote")
    }
}