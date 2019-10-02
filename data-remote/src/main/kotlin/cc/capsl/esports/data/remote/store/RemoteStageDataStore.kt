package cc.capsl.esports.data.remote.store

import cc.capsl.esports.data.StageData
import cc.capsl.esports.data.remote.service.StageService
import cc.capsl.esports.data.store.StageDataStore

class RemoteStageDataStore(private val service: StageService) : StageDataStore {

    override suspend fun load(): List<StageData> {
        return service
                .loadStages()
                .let { response ->
                    response
                            .results
                            ?.map {
                                StageData(it.id, it.name, it.active)
                            }
                }
    }

    override suspend fun save(stages: List<StageData>) {
        throw UnsupportedOperationException("Can't save to remote")
    }
}