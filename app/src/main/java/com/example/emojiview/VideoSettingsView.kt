package com.example.emojiview

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.MutableLiveData
import com.example.emojiview.databinding.VideoSettingsLayoutBinding


interface VideoSettingsClickListener {
    fun onQualityClick()
    fun onPlaybackSpeedClick()
    fun onCaptionsClick()
    fun onReportClick()
}

class VideoSettingsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
    var videoSettingsClickListener: VideoSettingsClickListener? = null
    private var sizeLoaded: MutableLiveData<Boolean> = MutableLiveData()
    private var animation: ObjectAnimator? = null
    private var moveDownOffset = 0f
    private var moveUpOffset = 0f
    private var parentHeight: Int = 0
    private lateinit var mainRootView: View
    var dY: Float = 0f
    var yUpperLimit = 0f
    var yLowerLimit = 0f

    var currentlyVisible = false
//    private val show: Boolean

    private var binding =
        VideoSettingsLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    init {
//        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.VideoCommentsSlideView)
//        show = typedArray.getBoolean(R.styleable.VideoCommentsSlideView_slideUp, false)
//        typedArray.recycle()
        sizeLoaded.value = false
        elevation = resources.getDimension(R.dimen._100sdp)
        setContentPadding(0, 0, 0, 0)
        clipToPadding = true
        clipChildren = true
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        parentHeight = (parent as View).height
        moveDownOffset = parentHeight.toFloat()
        moveUpOffset =
            parentHeight.toFloat() - this.height.toFloat()
        mainRootView = this
        yUpperLimit = moveUpOffset
        yLowerLimit = parentHeight.toFloat() - (parentHeight * 10 / 100).toFloat()
        if (currentlyVisible) {
            this.visibility = View.VISIBLE
            this.y = parentHeight.toFloat()+20f
        } else {
            this.visibility = View.INVISIBLE
            this.y = parentHeight.toFloat()
        }
        if (sizeLoaded.value == false) {
            sizeLoaded.value = true
            setClickListeners()

        }
    }

    private fun setClickListeners() {
        binding.qualityLayout.setOnClickListener {
            videoSettingsClickListener?.onQualityClick()
            slideIt()
        }
        binding.playbackSpeedLayout.setOnClickListener {
            videoSettingsClickListener?.onPlaybackSpeedClick()
            slideIt()
        }
        binding.captionsLayout.setOnClickListener {
            videoSettingsClickListener?.onCaptionsClick()
            slideIt()
        }

    }

//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
////        if (show) {
////            this.visibility = View.VISIBLE
////            this.y = resources.getDimension(R.dimen._180sdp)
////        } else {
//            this.visibility = View.INVISIBLE
//            this.y = parentHeight.toFloat()
////        }
//    }

    fun slideUp(openByDrag: Boolean = false) {
        if (sizeLoaded.value == true) {
            slideUpOnSizeLoaded(openByDrag)
        } else {
            sizeLoaded.observe((context as AppCompatActivity), {
                if (it == true) {
                    slideUpOnSizeLoaded(openByDrag)
                }
            })
        }
    }

    fun slideIt() {
        if (currentlyVisible) {
            slideDown()
        } else {
            slideUp()
        }
    }

    private fun slideUpOnSizeLoaded(openByDrag: Boolean) {
        if (!currentlyVisible || openByDrag) {
            currentlyVisible = true
            if (!openByDrag) {
                this.y = parentHeight.toFloat()
            }
            this.visibility = View.VISIBLE
            animation = ObjectAnimator.ofFloat(mainRootView, "Y", moveUpOffset)
            animation?.duration = 200
            animation?.start()
            animation?.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    Log.e("animations", "Ended")
                    // blurView?.makeVisible()
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                    Log.e("animations", "Started")
                }

            })
        }
    }


    fun slideDown(openByDrag: Boolean = false) {
        if (currentlyVisible || openByDrag) {
            animation = ObjectAnimator.ofFloat(mainRootView, "Y", moveDownOffset)
            animation?.duration = 200
            animation?.start()
            animation?.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    this@VideoSettingsView.visibility = View.INVISIBLE
                    currentlyVisible = false
                    //blurView?.makeGone()
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

            })
        }
    }

//    fun setSelectedPlaybackSpeed(text: String) {
//        binding.selectedPlaybackSpeed.text = text
//    }
//
//    fun setViewModel(viewModel: VideoViewModel) {
//        this.viewModel = viewModel
//    }


}