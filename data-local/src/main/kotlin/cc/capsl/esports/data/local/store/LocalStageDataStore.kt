package cc.capsl.esports.data.local.store

import cc.capsl.esports.data.StageData
import cc.capsl.esports.data.local.dao.StageDao
import cc.capsl.esports.data.local.entity.StageEntity
import cc.capsl.esports.data.store.StageDataStore

class LocalStageDataStore(private val dao: StageDao) : StageDataStore {

    override suspend fun load(): List<StageData> {
        return dao
                .select()
                .map {
                    StageData(it.id, it.name, it.active)
                }
    }

    override suspend fun save(stages: List<StageData>) {
        stages
                .map { StageEntity(it.id, it.name, it.active) }
                .apply {
                    dao.insert(this)
                }
    }
}