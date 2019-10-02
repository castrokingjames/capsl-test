package cc.capsl.esports.di.module

import cc.capsl.esports.data.local.dao.GameDao
import cc.capsl.esports.data.local.store.LocalGameDataStore
import cc.capsl.esports.data.remote.service.GameService
import cc.capsl.esports.data.remote.store.RemoteGameDataStore
import cc.capsl.esports.data.repository.GameDataRepository
import cc.capsl.esports.data.store.GameDataStore
import cc.capsl.esports.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class GameModule {

    @Provides
    fun providesGameRepository(gameDataStoreFactory: GameDataStore.Factory): GameRepository {
        return GameDataRepository(gameDataStoreFactory)
    }

    @Provides
    fun providesGameDataStoreFactory(@Named("local") local: GameDataStore,
                                     @Named("remote") remote: GameDataStore): GameDataStore.Factory {
        return GameDataStoreFactory(local, remote)
    }

    @Provides
    @Named("local")
    fun providesLocalGameDataStore(gameDao: GameDao): GameDataStore {
        return LocalGameDataStore(gameDao)
    }

    @Provides
    @Named("remote")
    fun providesRemoteGameDataStore(gameService: GameService): GameDataStore {
        return RemoteGameDataStore(gameService)
    }

    class GameDataStoreFactory(private val local: GameDataStore, private val remote: GameDataStore) : GameDataStore.Factory {

        override fun createLocalDataStore(): GameDataStore {
            return local
        }

        override fun createRemoteDataStore(): GameDataStore {
            return remote
        }
    }
}