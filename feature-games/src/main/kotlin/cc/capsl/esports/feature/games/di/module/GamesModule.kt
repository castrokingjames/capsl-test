package cc.capsl.esports.feature.games.di.module

import cc.capsl.esports.feature.games.GamesFragment
import cc.capsl.esports.feature.games.di.component.GamesSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
        subcomponents = [
            GamesSubComponent::class
        ]
)
abstract class GamesModule {

    @Binds
    @IntoMap
    @ClassKey(GamesFragment::class)
    abstract fun bindGamesFragmentInjectorFactory(factory: GamesSubComponent.Factory): AndroidInjector.Factory<*>
}