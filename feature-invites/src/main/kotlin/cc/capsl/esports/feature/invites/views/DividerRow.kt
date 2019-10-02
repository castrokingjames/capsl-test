package cc.capsl.esports.feature.invites.views

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import cc.capsl.esports.feature.invites.R
import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.ModelView

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class DividerRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.row_divider, this)
    }
}