package cc.capsl.esports.feature.tournaments.views

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import android.widget.TextView
import cc.capsl.esports.feature.tournaments.R
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class HeaderRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val nameTextView: TextView

    init {
        inflate(context, R.layout.row_header, this)
        nameTextView = findViewById(R.id.nameTextView)
    }

    @TextProp
    fun setName(name: CharSequence) {
        nameTextView.text = name
    }
}