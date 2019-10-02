package cc.capsl.esports.di.module

import cc.capsl.esports.data.local.dao.UserDao
import cc.capsl.esports.data.local.store.LocalUserDataStore
import cc.capsl.esports.data.remote.service.UserService
import cc.capsl.esports.data.remote.store.RemoteUserDataStore
import cc.capsl.esports.data.repository.UserDataRepository
import cc.capsl.esports.data.store.UserDataStore
import cc.capsl.esports.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserModule {

    @Provides
    fun providesUserRepository(stageDataStoreFactory: UserDataStore.Factory): UserRepository {
        return UserDataRepository(stageDataStoreFactory)
    }

    @Provides
    fun providesUserDataStoreFactory(@Named("local") local: UserDataStore,
                                     @Named("remote") remote: UserDataStore): UserDataStore.Factory {
        return UserDataStoreFactory(local, remote)
    }

    @Provides
    @Named("local")
    fun providesLocalUserDataStore(stageDao: UserDao): UserDataStore {
        return LocalUserDataStore(stageDao)
    }

    @Provides
    @Named("remote")
    fun providesRemoteUserDataStore(stageService: UserService): UserDataStore {
        return RemoteUserDataStore(stageService)
    }

    class UserDataStoreFactory(private val local: UserDataStore, private val remote: UserDataStore) : UserDataStore.Factory {

        override fun createLocalDataStore(): UserDataStore {
            return local
        }

        override fun createRemoteDataStore(): UserDataStore {
            return remote
        }
    }
}