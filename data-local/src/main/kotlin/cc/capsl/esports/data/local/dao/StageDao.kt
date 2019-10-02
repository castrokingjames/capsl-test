package cc.capsl.esports.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import cc.capsl.esports.data.local.entity.StageEntity

@Dao
interface StageDao : RoomDao<StageEntity> {

    @Query("SELECT * FROM Stages ORDER BY name ASC")
    suspend fun select(): List<StageEntity>
}