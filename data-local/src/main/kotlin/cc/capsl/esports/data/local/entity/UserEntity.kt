package cc.capsl.esports.data.local.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(
        tableName = "Users",
        primaryKeys = [
            "id"
        ],
        indices = [
            (Index(value = ["id"]))
        ]
)
data class UserEntity(
        val id: Int,
        val username: String,
        val firstName: String,
        val lastName: String
)