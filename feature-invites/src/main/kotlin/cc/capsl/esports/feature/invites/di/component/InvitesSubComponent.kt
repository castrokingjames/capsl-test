package cc.capsl.esports.feature.invites.di.component

import cc.capsl.esports.di.module.UserModule
import cc.capsl.esports.di.module.ViewModelFactoryModule
import cc.capsl.esports.di.scope.ForFragment
import cc.capsl.esports.feature.invites.InvitesFragment
import cc.capsl.esports.feature.invites.di.module.InvitesAssistedModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ForFragment
@Subcomponent(
        modules = [
            ViewModelFactoryModule::class,
            InvitesAssistedModule::class,
            UserModule::class
        ]
)
interface InvitesSubComponent : AndroidInjector<InvitesFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<InvitesFragment>
}