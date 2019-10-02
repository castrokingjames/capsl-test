package cc.capsl.esports.data.local.store

import cc.capsl.esports.data.UserData
import cc.capsl.esports.data.local.dao.UserDao
import cc.capsl.esports.data.local.entity.UserEntity
import cc.capsl.esports.data.store.UserDataStore

class LocalUserDataStore(private val dao: UserDao) : UserDataStore {

    override suspend fun load(): List<UserData> {
        return dao
                .select()
                .map {
                    UserData(it.id, it.firstName, it.firstName, it.lastName)
                }
    }

    override suspend fun save(users: List<UserData>) {
        users
                .map { UserEntity(it.id, it.firstName, it.firstName, it.lastName) }
                .apply {
                    dao.insert(this)
                }
    }
}