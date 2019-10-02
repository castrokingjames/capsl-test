package cc.capsl.esports.feature.invites.di.component

import cc.capsl.esports.di.scope.ForActivity
import cc.capsl.esports.feature.invites.InvitesActivity
import cc.capsl.esports.feature.invites.di.module.InvitesModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForActivity
@Subcomponent(
        modules = [
            InvitesModule::class
        ]
)
interface InvitesComponent : AndroidInjector<InvitesActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<InvitesActivity>
}