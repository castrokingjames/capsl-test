package cc.capsl.esports.feature.invites.views

import android.content.Context
import android.util.AttributeSet
import android.widget.*
import cc.capsl.esports.feature.invites.R
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class UserRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val nameTextView: TextView
    private val thumbImageView: ImageView
    private val checkbox: CheckBox

    init {
        inflate(context, R.layout.row_user, this)
        nameTextView = findViewById(R.id.nameTextView)
        thumbImageView = findViewById(R.id.thumbImageView)
        checkbox = findViewById(R.id.checkbox)
    }

    @TextProp
    fun setName(name: CharSequence) {
        nameTextView.text = name
    }

    @CallbackProp
    fun setCheckedChangeListener(onCheckedChangeListener: CompoundButton.OnCheckedChangeListener?) {
        checkbox.setOnCheckedChangeListener(onCheckedChangeListener)
        setOnClickListener {
            checkbox.isChecked = !checkbox.isChecked
        }
    }

    @TextProp
    fun setUrl(url: CharSequence) {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_profile_placeholder)
        requestOptions.error(R.drawable.ic_profile_placeholder)
        requestOptions.fallback(R.drawable.ic_profile_placeholder)
        requestOptions.circleCrop()

        Glide
                .with(this)
                .load(url)
                .apply(requestOptions)
                .into(thumbImageView)
    }
}