package cc.capsl.esports.feature.tournaments

import cc.capsl.esports.domain.repository.StageRepository
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

class TournamentsViewModel @AssistedInject constructor(
        @Assisted state: TournamentsViewState,
        private val repository: StageRepository
) : MvRxViewModel<TournamentsViewState>(state), CoroutineScope {

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
                                copy(stages = Success(it))
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
        fun create(state: TournamentsViewState): TournamentsViewModel
    }

    companion object : MvRxViewModelFactory<TournamentsViewModel, TournamentsViewState> {
        override fun create(viewModelContext: ViewModelContext, state: TournamentsViewState): TournamentsViewModel? {
            val fragment: TournamentsFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.tournamentsViewModelFactory.create(state)
        }
    }
}