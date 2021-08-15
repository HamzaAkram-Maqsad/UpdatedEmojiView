package com.example.emojiview

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import kotlin.math.min
import kotlin.math.roundToInt

class CustomProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var strokeWidth = 4f
    private var progress = 0f
    private var min = 0
    private var max = 100

    private var startAngle = -90f
    private var color: Int = Color.DKGRAY
    private var rectF: RectF? = null
    private var backgroundPaint: Paint? = null
    private var foregroundPaint: Paint? = null
    fun getStrokeWidth(): Float {
        return strokeWidth
    }

    fun setStrokeWidth(strokeWidth: Float) {
        this.strokeWidth = strokeWidth
        backgroundPaint!!.strokeWidth = strokeWidth
        foregroundPaint!!.strokeWidth = strokeWidth
        invalidate()
        requestLayout() //Because it should recalculate its bounds
    }

    fun getProgress(): Float {
        return progress
    }

    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }

    fun getMin(): Int {
        return min
    }

    fun setMin(min: Int) {
        this.min = min
        invalidate()
    }

    fun getMax(): Int {
        return max
    }

    fun setMax(max: Int) {
        this.max = max
        invalidate()
    }

    fun getColor(): Int {
        return color
    }

    fun setColor(color: Int) {
        this.color = color
        backgroundPaint!!.color = adjustAlpha(color, 0.3f)
        foregroundPaint!!.color = color
        invalidate()
        requestLayout()
    }

    init {
        rectF = RectF()
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar)
        try {
            strokeWidth =
                typedArray.getDimension(
                    R.styleable.CustomProgressBar_progressBarThickness,
                    strokeWidth
                )
            progress = typedArray.getFloat(R.styleable.CustomProgressBar_progress, progress)
            color = typedArray.getInt(R.styleable.CustomProgressBar_progressbarColor, color)
            min = typedArray.getInt(R.styleable.CustomProgressBar_min, min)
            max = typedArray.getInt(R.styleable.CustomProgressBar_max, max)
        } finally {
            typedArray.recycle()
        }

        backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        backgroundPaint!!.color = adjustAlpha(color, 0.3f)
        backgroundPaint!!.style = Paint.Style.STROKE
        backgroundPaint!!.strokeWidth = strokeWidth

        foregroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        foregroundPaint!!.color = color
        foregroundPaint!!.style = Paint.Style.STROKE
        foregroundPaint!!.strokeWidth = strokeWidth
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawOval(rectF!!, backgroundPaint!!)
        val angle = 360 * progress / max
        canvas.drawArc(rectF!!, startAngle, angle, false, foregroundPaint!!)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val min = min(width, height)
        setMeasuredDimension(min, min)
        rectF!![0 + strokeWidth / 2, 0 + strokeWidth / 2, min - strokeWidth / 2] =
            min - strokeWidth / 2
    }

    /**
     * Lighten the given color by the factor
     *
     * @param color  The color to lighten
     * @param factor 0 to 4
     * @return A brighter color
     */
    fun lightenColor(color: Int, factor: Float): Int {
        val r = Color.red(color) * factor
        val g = Color.green(color) * factor
        val b = Color.blue(color) * factor
        val ir = min(255, r.toInt())
        val ig = min(255, g.toInt())
        val ib = min(255, b.toInt())
        val ia = Color.alpha(color)
        return Color.argb(ia, ir, ig, ib)
    }

    /**
     * Transparent the given color by the factor
     * The more the factor closer to zero the more the color gets transparent
     *
     * @param color  The color to transparent
     * @param factor 1.0f to 0.0f
     * @return int - A transplanted color
     */
    fun adjustAlpha(color: Int, factor: Float): Int {
        val alpha = (Color.alpha(color) * factor).roundToInt()
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        return Color.argb(alpha, red, green, blue)
    }

    /**
     * Set the progress with an animation.
     * Note that the [android.animation.ObjectAnimator] Class automatically set the progress
     * so don't call the [CircleProgressBar.setProgress] directly within this method.
     *
     * @param progress The progress it should animate to it.
     */
    fun setProgressWithAnimation(progress: Float) {
        val objectAnimator = ObjectAnimator.ofFloat(this, "progress", progress)
        objectAnimator.duration = 1500
        objectAnimator.interpolator = DecelerateInterpolator()
        objectAnimator.start()
    }
}