package cc.capsl.esports.data.remote.response

data class StageResponse(var count: Int,
                         var next: Int,
                         var previous: Int,
                         val results: List<StageResultResponse>) {

    data class StageResultResponse(var id: Int,
                                   var name: String,
                                   var active: Boolean)
}