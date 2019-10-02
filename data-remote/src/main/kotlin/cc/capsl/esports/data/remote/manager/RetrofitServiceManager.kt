package cc.capsl.esports.data.remote.manager

import cc.capsl.esports.data.remote.service.GameService
import cc.capsl.esports.data.remote.service.StageService
import cc.capsl.esports.data.remote.service.UserService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitServiceManager : ServiceManager {

    private var retrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl("http://13.231.86.234:5000")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(client)
                .build()
    }

    override fun gameService(): GameService {
        return retrofit.create(GameService::class.java)
    }

    override fun stageService(): StageService {
        return retrofit.create(StageService::class.java)
    }

    override fun userService(): UserService {
        return retrofit.create(UserService::class.java)
    }
}