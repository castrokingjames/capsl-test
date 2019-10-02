package cc.capsl.esports.feature.games

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import cc.capsl.esports.feature.games.views.gameRow
import cc.capsl.esports.ui.mvrx.MvRxFragment
import cc.capsl.esports.ui.mvrx.simpleController
import cc.capsl.esports.ui.navigation.Activities
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class GamesFragment : MvRxFragment() {

    @Inject
    lateinit var gamesViewModelFactory: GamesViewModel.Factory

    private val viewModel: GamesViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(requireContext(), 2)
        layoutManager.spanSizeLookup = epoxyController.spanSizeLookup
        recyclerView.layoutManager = layoutManager
    }

    override fun epoxyController() = simpleController(viewModel) { state ->
        when (val games = state.games) {
            is Success -> {
                games
                        .invoke()
                        .map {
                            gameRow {
                                id(it.id)
                                name(it.name)
                                url(it.image)
                                spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount / 2 }
                                clickListener { _ ->
                                    startActivity(Activities.intentForTournaments(requireContext(), it.id))
                                }
                            }
                        }
            }
        }
    }
}