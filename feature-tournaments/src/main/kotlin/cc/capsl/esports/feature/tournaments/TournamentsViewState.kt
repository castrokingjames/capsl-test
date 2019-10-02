package cc.capsl.esports.feature.tournaments

import cc.capsl.esports.domain.Stage
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class TournamentsViewState(val gameId: Int = 0, val stages: Async<List<Stage>> = Uninitialized) : MvRxState {
    constructor(args: TournamentArgs) : this(gameId = args.gameId)
}