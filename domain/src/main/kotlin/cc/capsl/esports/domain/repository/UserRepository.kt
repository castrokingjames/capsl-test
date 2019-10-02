package cc.capsl.esports.domain.repository

import cc.capsl.esports.domain.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun load(): Flow<List<User>>
}