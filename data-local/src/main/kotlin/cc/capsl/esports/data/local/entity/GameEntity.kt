package cc.capsl.esports.data.local.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(
        tableName = "Games",
        primaryKeys = [
            "id"
        ],
        indices = [
            (Index(value = ["id"]))
        ]
)
data class GameEntity(
        val id: Int,
        val name: String,
        val image: String
)