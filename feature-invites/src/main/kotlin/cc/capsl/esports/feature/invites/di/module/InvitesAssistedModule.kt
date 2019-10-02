package cc.capsl.esports.feature.invites.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@Module(includes = [AssistedInject_InvitesAssistedModule::class])
@AssistedModule
interface InvitesAssistedModule