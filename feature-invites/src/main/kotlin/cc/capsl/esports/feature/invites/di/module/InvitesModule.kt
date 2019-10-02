package cc.capsl.esports.feature.invites.di.module

import cc.capsl.esports.feature.invites.InvitesFragment
import cc.capsl.esports.feature.invites.di.component.InvitesSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
        subcomponents = [
            InvitesSubComponent::class
        ]
)
abstract class InvitesModule {

    @Binds
    @IntoMap
    @ClassKey(InvitesFragment::class)
    abstract fun bindInvitesFragmentInjectorFactory(factory: InvitesSubComponent.Factory): AndroidInjector.Factory<*>
}