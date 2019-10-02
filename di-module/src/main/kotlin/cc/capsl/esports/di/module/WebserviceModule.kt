package cc.capsl.esports.di.module

import cc.capsl.esports.data.remote.manager.RetrofitServiceManager
import cc.capsl.esports.data.remote.manager.ServiceManager
import cc.capsl.esports.data.remote.service.GameService
import cc.capsl.esports.data.remote.service.StageService
import cc.capsl.esports.data.remote.service.UserService
import dagger.Module
import dagger.Provides

@Module
class WebserviceModule {

    @Provides
    fun providesServiceManager(): ServiceManager {
        return RetrofitServiceManager()
    }

    @Provides
    fun providesGameService(serviceManager: ServiceManager): GameService {
        return serviceManager.gameService()
    }

    @Provides
    fun providesStageService(serviceManager: ServiceManager): StageService {
        return serviceManager.stageService()
    }

    @Provides
    fun providesUserService(serviceManager: ServiceManager): UserService {
        return serviceManager.userService()
    }
}