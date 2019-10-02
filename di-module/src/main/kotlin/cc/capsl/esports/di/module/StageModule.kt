package cc.capsl.esports.di.module

import cc.capsl.esports.data.local.dao.StageDao
import cc.capsl.esports.data.local.store.LocalStageDataStore
import cc.capsl.esports.data.remote.service.StageService
import cc.capsl.esports.data.remote.store.RemoteStageDataStore
import cc.capsl.esports.data.repository.StageDataRepository
import cc.capsl.esports.data.store.StageDataStore
import cc.capsl.esports.domain.repository.StageRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class StageModule {

    @Provides
    fun providesStageRepository(stageDataStoreFactory: StageDataStore.Factory): StageRepository {
        return StageDataRepository(stageDataStoreFactory)
    }

    @Provides
    fun providesStageDataStoreFactory(@Named("local") local: StageDataStore,
                                     @Named("remote") remote: StageDataStore): StageDataStore.Factory {
        return StageDataStoreFactory(local, remote)
    }

    @Provides
    @Named("local")
    fun providesLocalStageDataStore(stageDao: StageDao): StageDataStore {
        return LocalStageDataStore(stageDao)
    }

    @Provides
    @Named("remote")
    fun providesRemoteStageDataStore(stageService: StageService): StageDataStore {
        return RemoteStageDataStore(stageService)
    }

    class StageDataStoreFactory(private val local: StageDataStore, private val remote: StageDataStore) : StageDataStore.Factory {

        override fun createLocalDataStore(): StageDataStore {
            return local
        }

        override fun createRemoteDataStore(): StageDataStore {
            return remote
        }
    }
}