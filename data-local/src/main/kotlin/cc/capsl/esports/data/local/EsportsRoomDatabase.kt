package cc.capsl.esports.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import cc.capsl.esports.data.local.dao.GameDao
import cc.capsl.esports.data.local.dao.StageDao
import cc.capsl.esports.data.local.dao.UserDao
import cc.capsl.esports.data.local.entity.GameEntity
import cc.capsl.esports.data.local.entity.StageEntity
import cc.capsl.esports.data.local.entity.UserEntity

@Database(
        entities = [
            GameEntity::class,
            StageEntity::class,
            UserEntity::class
        ],
        version = 1,
        exportSchema = false
)
abstract class EsportsRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    abstract fun stageDao(): StageDao

    abstract fun userDao(): UserDao
}