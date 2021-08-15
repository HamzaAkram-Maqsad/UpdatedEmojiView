package com.example.emojiview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.emojiview.databinding.ActivityDashboardBinding
import com.example.emojiview.fragments.BookmarksFragment
import com.example.emojiview.fragments.HomeFragment
import com.example.emojiview.fragments.ProfileFragment
import com.example.emojiview.fragments.StreaksFragment

class DashboardActivity : AppCompatActivity() {
    private lateinit var bottomNavAdapter: DashboardBottomNavAdapter
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeStatusBarColor()
        setViewPager()
    }

    @SuppressLint("InflateParams")
    private fun setViewPager() {
        bottomNavAdapter = DashboardBottomNavAdapter(supportFragmentManager, listOf())
        bottomNavAdapter.addFragment(HomeFragment.newInstance())
        bottomNavAdapter.addFragment(StreaksFragment.newInstance())
        bottomNavAdapter.addFragment(BookmarksFragment.newInstance())
        bottomNavAdapter.addFragment(ProfileFragment.newInstance())
        binding.mainViewpager.adapter = bottomNavAdapter
        binding.mainViewpager.offscreenPageLimit = bottomNavAdapter.count - 1
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    binding.mainViewpager.currentItem = 0
                }
                R.id.nav_streaks -> {
                    binding.mainViewpager.currentItem = 1
                }
                R.id.nav_bookmarks -> {
                    binding.mainViewpager.currentItem = 2
                }
                R.id.nav_profile -> {
                    binding.mainViewpager.currentItem = 3
                }
            }
            return@setOnItemSelectedListener true
        }
        binding.mainViewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottomNavView.menu.findItem(R.id.nav_home).isChecked = true
                    1 -> binding.bottomNavView.menu.findItem(R.id.nav_streaks).isChecked = true
                    2 -> binding.bottomNavView.menu.findItem(R.id.nav_bookmarks).isChecked = true
                    3 -> binding.bottomNavView.menu.findItem(R.id.nav_profile).isChecked = true
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }

}