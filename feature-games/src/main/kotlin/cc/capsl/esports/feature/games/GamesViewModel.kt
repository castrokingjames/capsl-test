package cc.capsl.esports.feature.games

import cc.capsl.esports.domain.repository.GameRepository
import cc.capsl.esports.ui.mvrx.MvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

class GamesViewModel @AssistedInject constructor(
        @Assisted state: GamesViewState,
        private val repository: GameRepository
) : MvRxViewModel<GamesViewState>(state), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    init {
        load()
    }

    private fun load() {
        launch(Dispatchers.IO) {
            repository
                    .load()
                    .collect {
                        withContext(Dispatchers.Main) {
                            setState {
                                copy(games = Success(it))
                            }
                        }
                    }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: GamesViewState): GamesViewModel
    }

    companion object : MvRxViewModelFactory<GamesViewModel, GamesViewState> {
        override fun create(viewModelContext: ViewModelContext, state: GamesViewState): GamesViewModel? {
            val fragment: GamesFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.gamesViewModelFactory.create(state)
        }
    }
}