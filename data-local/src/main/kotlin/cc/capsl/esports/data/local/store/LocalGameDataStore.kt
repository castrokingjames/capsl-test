package cc.capsl.esports.data.local.store

import cc.capsl.esports.data.GameData
import cc.capsl.esports.data.local.dao.GameDao
import cc.capsl.esports.data.local.entity.GameEntity
import cc.capsl.esports.data.store.GameDataStore

class LocalGameDataStore(private val dao: GameDao) : GameDataStore {

    override suspend fun load(): List<GameData> {
        return dao
                .select()
                .map {
                    GameData(it.id, it.name, it.image)
                }
    }

    override suspend fun save(games: List<GameData>) {
        games
                .map { GameEntity(it.id, it.name, it.image) }
                .apply {
                    dao.insert(this)
                }
    }
}