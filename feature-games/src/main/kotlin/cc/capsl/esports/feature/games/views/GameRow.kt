package cc.capsl.esports.feature.games.views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import cc.capsl.esports.feature.games.R
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.bumptech.glide.Glide

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class GameRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val nameTextView: TextView
    private val urlImageView: ImageView

    init {
        inflate(context, R.layout.row_game, this)
        nameTextView = findViewById(R.id.nameTextView)
        urlImageView = findViewById(R.id.urlImageView)
    }

    @TextProp
    fun setName(name: CharSequence) {
        nameTextView.text = name
    }

    @TextProp
    fun setUrl(url: CharSequence) {
        Glide.with(this).load(url).into(urlImageView);
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        setOnClickListener(clickListener)
    }
}