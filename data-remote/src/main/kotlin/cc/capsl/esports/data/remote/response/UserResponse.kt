package cc.capsl.esports.data.remote.response

data class UserResponse(var count: Int,
                        var next: String,
                        var previous: String,
                        val results: List<UserResultResponse>) {

    data class UserResultResponse(var id: Int,
                                  var profile: UserProfileResult)

    data class UserProfileResult(var user_id: Int,
                                 var username: String,
                                 var first_name: String,
                                 var last_name: String,
                                 var clash_royale_tag: String
    )
}