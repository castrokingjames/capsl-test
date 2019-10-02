package cc.capsl.esports.feature.games.di.component

import cc.capsl.esports.di.scope.ForActivity
import cc.capsl.esports.feature.games.GamesActivity
import cc.capsl.esports.feature.games.di.module.GamesModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForActivity
@Subcomponent(
        modules = [
            GamesModule::class
        ]
)
interface GamesComponent : AndroidInjector<GamesActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<GamesActivity>
}