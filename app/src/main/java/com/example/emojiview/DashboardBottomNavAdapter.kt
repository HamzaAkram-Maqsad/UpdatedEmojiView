@file:Suppress("DEPRECATION")

package com.example.emojiview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class DashboardBottomNavAdapter(manager: FragmentManager, private val listTitles: List<String>) :
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragmentList = ArrayList<Fragment>()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return listTitles[position]
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }
}