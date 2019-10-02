package cc.capsl.esports.feature.games.di.component

import cc.capsl.esports.di.module.GameModule
import cc.capsl.esports.di.scope.ForFragment
import cc.capsl.esports.feature.games.GamesFragment
import cc.capsl.esports.feature.games.di.module.GamesAssistedModule
import cc.capsl.esports.di.module.ViewModelFactoryModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForFragment
@Subcomponent(
        modules = [
            ViewModelFactoryModule::class,
            GamesAssistedModule::class,
            GameModule::class
        ]
)
interface GamesSubComponent : AndroidInjector<GamesFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<GamesFragment>
}