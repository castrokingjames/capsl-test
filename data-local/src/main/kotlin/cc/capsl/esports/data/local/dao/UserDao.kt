package cc.capsl.esports.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import cc.capsl.esports.data.local.entity.StageEntity
import cc.capsl.esports.data.local.entity.UserEntity

@Dao
interface UserDao : RoomDao<UserEntity> {

    @Query("SELECT * FROM Users ORDER BY firstName ASC")
    suspend fun select(): List<UserEntity>
}