package cc.capsl.esports.feature.tournaments.di.component

import cc.capsl.esports.di.scope.ForActivity
import cc.capsl.esports.feature.tournaments.TournamentsActivity
import cc.capsl.esports.feature.tournaments.di.module.TournamentsModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForActivity
@Subcomponent(
        modules = [
            TournamentsModule::class
        ]
)
interface TournamentsComponent : AndroidInjector<TournamentsActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<TournamentsActivity>
}