@file:Suppress("DEPRECATION")

package com.example.emojiview

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import kotlin.system.exitProcess
//
//fun AppCompatActivity.printLog(text: String) {
//    if (!BuildConfig.IS_PRODUCTION) {
//        Log.e(this::class.java.simpleName, text)
//    }
//}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun String.showToastShort(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String.showToastLong(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}

fun Activity.saveParentWidth(parentWidth: Int) {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = preferences.edit()
    editor.putInt("PARENT_WIDTH", parentWidth)
    editor.apply()
}

fun Activity.getSavedParentWidth(): Int {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    return preferences.getInt("PARENT_WIDTH", 0)
}

fun Activity.enableDisableViewGroup(viewGroup: ViewGroup, enabled: Boolean) {
    val childCount = viewGroup.childCount
    for (i in 0 until childCount) {
        val view = viewGroup.getChildAt(i)
        view.isEnabled = enabled
        if (view is ViewGroup) {
            enableDisableViewGroup(view, enabled)
        }
    }
}

fun TabLayout.enableDisable(enabled: Boolean) {
    val tabStrip = this.getChildAt(0) as LinearLayout
    tabStrip.isEnabled = enabled
    for (i in 0 until tabStrip.childCount) {
        tabStrip.getChildAt(i).isClickable = enabled
    }
}

fun Activity.closeApp() {
    Toast.makeText(this, "Closing App", Toast.LENGTH_LONG).show()
    Handler(Looper.getMainLooper()).postDelayed({
        finishAffinity()
        exitProcess(0)
    }, 500)
}


@SuppressLint("InlinedApi")
fun Activity.changeStatusBarColor(isLight: Boolean = true) {
    if (isLight) {
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
                Log.e("UI_MODE_NIGHT_NO", "Light")
                window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                Log.e("UI_MODE_NIGHT_YES", "Dark")
                window.decorView.systemUiVisibility =
                    window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
        }
        window.statusBarColor = ContextCompat.getColor(
            this,
            R.color.backgroundColor
        ) // set status background white
    } else {
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        val decorView: View = window.decorView //set status background black
        decorView.systemUiVisibility =
            decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() //set status text  light
    }
}

fun ScrollView.scrollToBottom() {
    val lastChild = getChildAt(childCount - 1)
    val bottom = lastChild.bottom + paddingBottom
    val delta = bottom - (scrollY + height)
    smoothScrollTo(0, delta)
//    smoothScrollBy(0, delta)
}
