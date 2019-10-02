package cc.capsl.esports.domain.repository

import cc.capsl.esports.domain.Stage
import kotlinx.coroutines.flow.Flow

interface StageRepository {

    suspend fun load(): Flow<List<Stage>>
}