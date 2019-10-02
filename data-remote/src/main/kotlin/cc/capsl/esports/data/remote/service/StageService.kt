package cc.capsl.esports.data.remote.service

import cc.capsl.esports.data.remote.response.StageResponse
import retrofit2.http.GET

interface StageService {

    @GET("/api/stages/")
    suspend fun loadStages(): StageResponse
}