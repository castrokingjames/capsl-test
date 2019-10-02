package cc.capsl.esports.data.store

import cc.capsl.esports.data.UserData

interface UserDataStore {

    suspend fun load(): List<UserData>

    suspend fun save(games: List<UserData>)

    interface Factory {

        fun createLocalDataStore(): UserDataStore

        fun createRemoteDataStore(): UserDataStore
    }
}