package cc.capsl.esports.data.repository

import cc.capsl.esports.data.UserData
import cc.capsl.esports.data.store.UserDataStore
import cc.capsl.esports.domain.User
import cc.capsl.esports.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserDataRepository(private val userDataStoreFactory: UserDataStore.Factory) : UserRepository {

    override suspend fun load(): Flow<List<User>> {
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
                        User(it.id, it.username, it.firstName, it.lastName)
                    }
                    .apply {
                        emit(this)
                        loadFromNetwork()
                                .apply {
                                    saveToLocal(this)
                                }
                        loadFromLocal()
                                .map {
                                    User(it.id, it.username, it.firstName, it.lastName)
                                }
                                .apply {
                                    emit(this)
                                }
                    }
        }
    }

    private suspend fun loadFromNetwork(): List<UserData> {
        val remote = userDataStoreFactory.createRemoteDataStore()
        return remote.load()
    }

    private suspend fun loadFromLocal(): List<UserData> {
        val local = userDataStoreFactory.createLocalDataStore()
        return local.load()
    }

    private suspend fun saveToLocal(games: List<UserData>) {
        val local = userDataStoreFactory.createLocalDataStore()
        local.save(games)
    }
}