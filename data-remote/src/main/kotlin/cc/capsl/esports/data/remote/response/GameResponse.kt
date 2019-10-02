package cc.capsl.esports.data.remote.response

data class GameResponse(var count: Int,
                        var next: Int,
                        var previous: Int,
                        val results: List<GameResultResponse>) {

    data class GameResultResponse(var id: Int,
                                  var name: String,
                                  var image: String,
                                  var package_id: String)
}