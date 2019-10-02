package cc.capsl.esports.domain.repository

import cc.capsl.esports.domain.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    suspend fun load(): Flow<List<Game>>
}