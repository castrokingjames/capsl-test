package cc.capsl.esports.feature.invites

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import cc.capsl.esports.ui.mvrx.MvRxActivity
import cc.capsl.esports.ui.navigation.Extra
import com.airbnb.mvrx.MvRx
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_invites.*
import javax.inject.Inject

class InvitesActivity : MvRxActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invites)

        val extras = intent.extras
        val gameId = extras?.getInt(Extra.GAME_ID) ?: -1
        val stageId = extras?.getInt(Extra.STAGE_ID) ?: -1
        val bundle = Bundle()
        bundle.putParcelable(MvRx.KEY_ARG, InvitesArgs(gameId, stageId))
        val navHostFragment = fragment as NavHostFragment
        val navController = navHostFragment.navController
        navController.setGraph(R.navigation.navigation_invites, bundle)
    }
}