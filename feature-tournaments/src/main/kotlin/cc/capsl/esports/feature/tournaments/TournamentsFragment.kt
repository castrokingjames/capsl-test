package cc.capsl.esports.feature.tournaments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import cc.capsl.esports.feature.tournaments.views.tournamentRow
import cc.capsl.esports.feature.tournaments.views.headerRow
import cc.capsl.esports.ui.mvrx.MvRxFragment
import cc.capsl.esports.ui.mvrx.simpleController
import cc.capsl.esports.ui.navigation.Activities
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TournamentsFragment : MvRxFragment() {

    @Inject
    lateinit var tournamentsViewModelFactory: TournamentsViewModel.Factory

    private val viewModel: TournamentsViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDisplayHomeAsUpEnabled(true)
        setNavigationOnClickListener { requireActivity().finish() }
        val layoutManager = GridLayoutManager(requireContext(), 2)
        layoutManager.spanSizeLookup = epoxyController.spanSizeLookup
        recyclerView.layoutManager = layoutManager
    }

    override fun epoxyController() = simpleController(viewModel) { state ->
        when (val stages = state.stages) {
            is Success -> {
                headerRow {
                    id("header")
                    name(getString(R.string.choose_the_stage))
                }
                stages
                        .invoke()
                        .map {
                            tournamentRow {
                                id(it.id)
                                name(it.name)
                                url("")
                                spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount / 2 }
                                clickListener { _ ->
                                    startActivity(Activities.intentForInvites(requireContext(), state.gameId, it.id))
                                }
                            }
                        }
            }
        }
    }
}