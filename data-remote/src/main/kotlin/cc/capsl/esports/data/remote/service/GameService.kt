package cc.capsl.esports.data.remote.service

import cc.capsl.esports.data.remote.response.GameResponse
import retrofit2.http.GET

interface GameService {

    @GET("/api/games/")
    suspend fun loadGames(): GameResponse
}