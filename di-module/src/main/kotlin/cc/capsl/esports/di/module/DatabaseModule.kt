package cc.capsl.esports.di.module

import android.content.Context
import cc.capsl.esports.data.local.dao.GameDao
import cc.capsl.esports.data.local.dao.StageDao
import cc.capsl.esports.data.local.dao.UserDao
import cc.capsl.esports.data.local.manager.DatabaseManager
import cc.capsl.esports.data.local.manager.RoomDatabaseManager
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun providesDatabaseManager(context: Context): DatabaseManager {
        return RoomDatabaseManager(context)
    }

    @Provides
    fun providesGameDao(databaseManager: DatabaseManager): GameDao {
        return databaseManager.gameDao()
    }

    @Provides
    fun providesStageDao(databaseManager: DatabaseManager): StageDao {
        return databaseManager.stageDao()
    }

    @Provides
    fun providesUserDao(databaseManager: DatabaseManager):UserDao{
        return databaseManager.userDao()
    }
}