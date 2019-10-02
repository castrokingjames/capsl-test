package cc.capsl.esports.data.local.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(
        tableName = "Stages",
        primaryKeys = [
            "id"
        ],
        indices = [
            (Index(value = ["id"]))
        ]
)
data class StageEntity(
        val id: Int,
        val name: String,
        val active: Boolean
)