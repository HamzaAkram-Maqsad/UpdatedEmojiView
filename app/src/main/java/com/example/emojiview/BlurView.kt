package com.example.emojiview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.RelativeLayout



class BlurView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    init {
        elevation = resources.getDimension(R.dimen._50sdp)
        setBackgroundColor(Color.parseColor("#99000000"))
        isFocusable = true
        isClickable = true
    }

}
