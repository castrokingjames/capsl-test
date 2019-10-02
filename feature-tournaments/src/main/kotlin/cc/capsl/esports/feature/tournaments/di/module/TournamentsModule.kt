package cc.capsl.esports.feature.tournaments.di.module

import cc.capsl.esports.feature.tournaments.TournamentsFragment
import cc.capsl.esports.feature.tournaments.di.component.TournamentsSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
        subcomponents = [
            TournamentsSubComponent::class
        ]
)
abstract class TournamentsModule {

    @Binds
    @IntoMap
    @ClassKey(TournamentsFragment::class)
    abstract fun bindGamesFragmentInjectorFactory(factory: TournamentsSubComponent.Factory): AndroidInjector.Factory<*>
}