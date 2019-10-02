package cc.capsl.esports.data.remote.manager

import cc.capsl.esports.data.remote.service.GameService
import cc.capsl.esports.data.remote.service.StageService
import cc.capsl.esports.data.remote.service.UserService

interface ServiceManager {

    fun gameService(): GameService

    fun stageService(): StageService

    fun userService(): UserService
}