package cc.capsl.esports.feature.invites

import android.os.Bundle
import android.util.Log
import android.view.View
import cc.capsl.esports.feature.invites.views.userRow
import cc.capsl.esports.feature.invites.views.dividerRow
import cc.capsl.esports.ui.mvrx.MvRxFragment
import cc.capsl.esports.ui.mvrx.simpleController
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class InvitesFragment : MvRxFragment() {

    @Inject
    lateinit var invitesViewModelFactory: InvitesViewModel.Factory

    private val viewModel: InvitesViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDisplayHomeAsUpEnabled(true)
        setNavigationOnClickListener { requireActivity().finish() }
    }

    override fun invalidate() {
        super.invalidate()

        withState(viewModel) { state ->
            when (val users = state.users) {
                is Success -> {
                    val users = users.invoke()
                    val invited = state.invited
                    setTitle(getString(R.string.invite_to_tournament_x_of_y, invited.size, users.size))
                }
            }
        }
    }

    override fun epoxyController() = simpleController(viewModel) { state ->
        when (val users = state.users) {
            is Success -> {
                users
                        .invoke()
                        .map {
                            userRow {
                                id(it.id)
                                name("${it.firstName} ${it.lastName}")
                                url("")
                                checkedChangeListener { _, isChecked: Boolean ->
                                    if (isChecked) viewModel.invite(it)
                                    else viewModel.remove(it)
                                }
                            }
                            dividerRow {
                                id("${it.id}-divider")
                            }
                        }

            }
        }
    }
}