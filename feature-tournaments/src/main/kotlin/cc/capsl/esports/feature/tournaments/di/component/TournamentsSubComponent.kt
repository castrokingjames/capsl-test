package cc.capsl.esports.feature.tournaments.di.component

import cc.capsl.esports.di.module.StageModule
import cc.capsl.esports.di.module.ViewModelFactoryModule
import cc.capsl.esports.di.scope.ForFragment
import cc.capsl.esports.feature.tournaments.TournamentsFragment
import cc.capsl.esports.feature.tournaments.di.module.TournamentsAssistedModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForFragment
@Subcomponent(
        modules = [
            ViewModelFactoryModule::class,
            TournamentsAssistedModule::class,
            StageModule::class
        ]
)
interface TournamentsSubComponent : AndroidInjector<TournamentsFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<TournamentsFragment>
}