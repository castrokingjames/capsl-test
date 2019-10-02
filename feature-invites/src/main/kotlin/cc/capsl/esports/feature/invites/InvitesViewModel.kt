package cc.capsl.esports.feature.invites

import cc.capsl.esports.domain.User
import cc.capsl.esports.domain.repository.UserRepository
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

class InvitesViewModel @AssistedInject constructor(
        @Assisted state: InvitesViewState,
        private val repository: UserRepository
) : MvRxViewModel<InvitesViewState>(state), CoroutineScope {

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
                                copy(users = Success(it))
                            }
                        }
                    }
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun invite(user: User) {
        setState {
            copy(invited = invited + user)
        }
    }

    fun remove(user: User) {
        setState {
            copy(invited = invited - user)
        }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: InvitesViewState): InvitesViewModel
    }

    companion object : MvRxViewModelFactory<InvitesViewModel, InvitesViewState> {
        override fun create(viewModelContext: ViewModelContext, state: InvitesViewState): InvitesViewModel? {
            val fragment: InvitesFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.invitesViewModelFactory.create(state)
        }
    }
}