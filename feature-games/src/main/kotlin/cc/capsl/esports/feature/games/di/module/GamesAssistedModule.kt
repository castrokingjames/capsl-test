package cc.capsl.esports.feature.games.di.module

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@Module(includes = [AssistedInject_GamesAssistedModule::class])
@AssistedModule
interface GamesAssistedModule