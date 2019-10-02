package cc.capsl.esports.di.component

import android.app.Application
import cc.capsl.esports.EsportsApplication
import cc.capsl.esports.di.module.ApplicationModule
import cc.capsl.esports.di.module.DatabaseModule
import cc.capsl.esports.di.module.EsportsModule
import cc.capsl.esports.di.module.WebserviceModule
import cc.capsl.esports.di.scope.ForApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@ForApplication
@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            EsportsModule::class,
            DatabaseModule::class,
            WebserviceModule::class
        ]
)
interface EsportsComponent : AndroidInjector<EsportsApplication> {

    @Component.Factory
    interface Factory {

        fun create(module: ApplicationModule, @BindsInstance application: Application): EsportsComponent
    }

    override fun inject(app: EsportsApplication)
}