package cc.capsl.esports.feature.games

import cc.capsl.esports.domain.Game
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class GamesViewState(val games: Async<List<Game>> = Uninitialized) : MvRxState