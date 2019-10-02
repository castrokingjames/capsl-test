package cc.capsl.esports.data.store

import cc.capsl.esports.data.StageData

interface StageDataStore {

    suspend fun load(): List<StageData>

    suspend fun save(games: List<StageData>)

    interface Factory {

        fun createLocalDataStore(): StageDataStore

        fun createRemoteDataStore(): StageDataStore
    }
}