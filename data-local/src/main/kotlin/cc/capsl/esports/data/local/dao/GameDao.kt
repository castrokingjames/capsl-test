package cc.capsl.esports.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import cc.capsl.esports.data.local.entity.GameEntity

@Dao
interface GameDao : RoomDao<GameEntity> {

    @Query("SELECT * FROM Games ORDER BY name ASC")
    suspend fun select(): List<GameEntity>
}