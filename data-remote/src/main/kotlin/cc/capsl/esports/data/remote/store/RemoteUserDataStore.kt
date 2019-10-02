package cc.capsl.esports.data.remote.store

import cc.capsl.esports.data.UserData
import cc.capsl.esports.data.remote.service.UserService
import cc.capsl.esports.data.store.UserDataStore

class RemoteUserDataStore(private val service: UserService) : UserDataStore {

    override suspend fun load(): List<UserData> {
        return service
                .loadPlayers()
                .let { response ->
                    response
                            .results
                            ?.map {
                                UserData(it.profile.user_id, it.profile.username, it.profile.first_name, it.profile.last_name)
                            }
                }
    }

    override suspend fun save(users: List<UserData>) {
        throw UnsupportedOperationException("Can't save to remote")
    }
}