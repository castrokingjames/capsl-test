package cc.capsl.esports.di.module

import cc.capsl.esports.feature.games.GamesActivity
import cc.capsl.esports.feature.games.di.component.GamesComponent
import cc.capsl.esports.feature.invites.InvitesActivity
import cc.capsl.esports.feature.invites.di.component.InvitesComponent
import cc.capsl.esports.feature.tournaments.TournamentsActivity
import cc.capsl.esports.feature.tournaments.di.component.TournamentsComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
        subcomponents = [
            GamesComponent::class,
            TournamentsComponent::class,
            InvitesComponent::class
        ]
)
abstract class EsportsModule {

    @Binds
    @IntoMap
    @ClassKey(GamesActivity::class)
    abstract fun bindGamesActivityInjectorFactory(factory: GamesComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(TournamentsActivity::class)
    abstract fun bindTournamentsActivityInjectorFactory(factory: TournamentsComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(InvitesActivity::class)
    abstract fun bindInvitesActivityInjectorFactory(factory: InvitesComponent.Factory): AndroidInjector.Factory<*>

}