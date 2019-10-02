package cc.capsl.esports.data.remote.service

import cc.capsl.esports.data.remote.response.UserResponse
import retrofit2.http.GET

interface UserService {

    @GET("/api/players/")
    suspend fun loadPlayers(): UserResponse
}