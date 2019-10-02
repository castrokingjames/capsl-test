package cc.capsl.esports.data.store

import cc.capsl.esports.data.GameData

interface GameDataStore {

    suspend fun load(): List<GameData>

    suspend fun save(games: List<GameData>)

    interface Factory {

        fun createLocalDataStore(): GameDataStore

        fun createRemoteDataStore(): GameDataStore
    }
}