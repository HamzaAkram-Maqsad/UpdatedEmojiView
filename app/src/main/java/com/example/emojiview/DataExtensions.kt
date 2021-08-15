package com.example.emojiview

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import java.text.SimpleDateFormat
import java.util.*

//fun Activity.getPlaybackSpeedText(value: Float): String {
//    return when (value) {
//        0.5f -> resources.getString(R.string.speed_0_5)
//        1f -> resources.getString(R.string.normal)
//        1.5f -> resources.getString(R.string.speed_1_5)
//        2f -> resources.getString(R.string.speed_2_0)
//        2.5f -> resources.getString(R.string.speed_2_5)
//        else -> ""
//    }
//}
//
//fun <T> Iterator<T>.toList(): List<T> {
//    val list: MutableList<T> = ArrayList()
//    this.forEachRemaining { e: T -> list.add(e) }
//    return list
//}
fun Int.numberToPercentage(total: Int): Float {
    return (this.toFloat() / total.toFloat()) * 100
}

fun Float.percentageToNumber(total: Int): Int {
    return ((this / 100f) * total.toFloat()).toInt()
}


fun Activity.getViewedCount(): Int {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    return preferences.getInt("TOTAL_VIEWED_VIDEOS", 0)
}

fun Activity.getAllCoursesIds(): List<String> {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    val set = preferences.getStringSet("ALL_COURSES_IDS", HashSet())!!
    return set.map { item -> item }.reversed()
}

fun Activity.saveAllCoursesIds(courses: List<String>) {
    val set = HashSet<String>()
    courses.forEach {
        set.add(it)
    }
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = preferences.edit()
    editor.putStringSet("ALL_COURSES_IDS", set)
    editor.apply()
}

fun Activity.saveSelectedCourse(courseId: String, name: String, isMcat: Boolean) {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = preferences.edit()
    editor.putString("SELECTED_COURSE_ID", courseId)
    editor.putBoolean("IS_COURSE_MCAT", isMcat)
    editor.putString("SELECTED_COURSE_NAME", name)
    editor.apply()
}


fun Activity.getSelectedCourseId(): String {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    return preferences.getString("SELECTED_COURSE_ID", "")!!
}

fun Activity.getSelectedCourseName(): String {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    return preferences.getString("SELECTED_COURSE_NAME", "")!!
}


fun Activity.getUserDetails(): HashMap<String, String?> {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    val userName = preferences.getString("userName", "")
    val email = preferences.getString("email", "")
    val phoneNumber = preferences.getString("phoneNumber", "")
    return hashMapOf("userName" to userName, "phoneNumber" to phoneNumber, "email" to email)
}

fun Activity.saveUserState(value: Boolean, phoneNumber: String) {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = preferences.edit()
    editor.putBoolean("USER_STATE", value)
    editor.putString("PHONE_NUMBER", phoneNumber)
    editor.apply()
}

fun Activity.getUserState(): Boolean {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    return preferences.getBoolean("USER_STATE", false)
}

fun Activity.getSavedPhoneNumber(): String? {
    val preferences: SharedPreferences =
        applicationContext.getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
    return preferences.getString("PHONE_NUMBER", "")
}

fun Long.toDateString(): String {
    return SimpleDateFormat(
        "dd MMM yyyy",
        Locale.US
    ).format(Date(this))
}


fun Activity.pxToDp(px: Float): Float {
    return px / this.resources.displayMetrics.density
}

fun Activity.dpToPx(dp: Int): Float {
    return dp * this.resources.displayMetrics.density
}

fun Activity.sdpToPx(sdp: Float): Float {
    return sdp * this.resources.displayMetrics.density
}

fun String.countOccurrences(ch: Char): Int {
    return this.filter { it == ch }.count()
}
