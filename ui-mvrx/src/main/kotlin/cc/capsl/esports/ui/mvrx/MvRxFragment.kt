package cc.capsl.esports.ui.mvrx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.BaseMvRxFragment
import kotlinx.android.synthetic.main.fragment_mvrx.*

abstract class MvRxFragment : BaseMvRxFragment() {

    val recyclerView by lazy { epoxyRecyclerView }
    val epoxyController by lazy { epoxyController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        epoxyController.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mvrx, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val activity = requireActivity()
        if (activity is AppCompatActivity) {
            activity.setSupportActionBar(toolbar)
        }
        toolbar.setupWithNavController(findNavController())
        recyclerView.setController(epoxyController)
    }

    override fun invalidate() {
        recyclerView.requestModelBuild()
    }

    fun setDisplayHomeAsUpEnabled(showHomeAsUp: Boolean) {
        val activity = requireActivity()
        if (activity is AppCompatActivity) {
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(showHomeAsUp)
        }
    }

    fun setNavigationOnClickListener(listener: () -> Unit) {
        toolbar.setNavigationOnClickListener {
            listener.invoke()
        }
    }

    fun setTitle(title: String) {
        toolbar.title = title
    }

    /**
     * Provide the EpoxyController to use when building models for this Fragment.
     * Basic usages can simply use [simpleController]
     */
    abstract fun epoxyController(): MvRxEpoxyController

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        epoxyController.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        epoxyController.cancelPendingModelBuild()
        super.onDestroyView()
    }
}