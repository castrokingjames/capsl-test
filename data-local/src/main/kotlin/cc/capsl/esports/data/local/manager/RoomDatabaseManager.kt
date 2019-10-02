package cc.capsl.esports.data.local.manager

import android.content.Context
import androidx.room.Room
import cc.capsl.esports.data.local.EsportsRoomDatabase
import cc.capsl.esports.data.local.dao.GameDao
import cc.capsl.esports.data.local.dao.StageDao
import cc.capsl.esports.data.local.dao.UserDao

class RoomDatabaseManager(context: Context) : DatabaseManager {

    private val room: EsportsRoomDatabase = Room
            .databaseBuilder(context, EsportsRoomDatabase::class.java, "esports")
            .fallbackToDestructiveMigration()
            .build()

    override fun gameDao(): GameDao {
        return room.gameDao()
    }

    override fun stageDao(): StageDao {
        return room.stageDao()
    }

    override fun userDao(): UserDao {
        return room.userDao()
    }
}