package cc.capsl.esports.feature.invites

import cc.capsl.esports.domain.User
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class InvitesViewState(val gameId: Int = 0, val stageId: Int = 0, val users: Async<List<User>> = Uninitialized, val invited: List<User> = emptyList()) : MvRxState {
    constructor(args: InvitesArgs) : this(gameId = args.gameId, stageId = args.stageId)
}