package cc.capsl.esports.di.module

import androidx.lifecycle.ViewModelProvider
import cc.capsl.esports.di.viewmodel.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}