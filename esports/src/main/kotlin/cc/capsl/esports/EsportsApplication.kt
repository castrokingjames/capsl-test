package cc.capsl.esports

import android.app.Application
import cc.capsl.esports.di.component.DaggerEsportsComponent
import cc.capsl.esports.di.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class EsportsApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerEsportsComponent
                .factory()
                .create(ApplicationModule(this), this)
                .inject(this)
    }
}