package cc.capsl.esports.data.local.manager

import cc.capsl.esports.data.local.dao.GameDao
import cc.capsl.esports.data.local.dao.StageDao
import cc.capsl.esports.data.local.dao.UserDao

interface DatabaseManager {

    fun gameDao(): GameDao

    fun stageDao(): StageDao

    fun userDao(): UserDao
}