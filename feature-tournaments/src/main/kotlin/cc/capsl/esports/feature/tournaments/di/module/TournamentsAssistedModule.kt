package cc.capsl.esports.feature.tournaments.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@Module(includes = [AssistedInject_TournamentsAssistedModule::class])
@AssistedModule
interface TournamentsAssistedModule