package com.example.emojiview

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import com.example.emojiview.databinding.SampleCollapsingAnimationBinding
import com.example.emojiview.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavAdapter: DashboardBottomNavAdapter
    private lateinit var binding: SampleCollapsingAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SampleCollapsingAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeStatusBarColor()
        setViewPager()
    }

    @SuppressLint("InflateParams")
    private fun setViewPager() {
        bottomNavAdapter = DashboardBottomNavAdapter(
            supportFragmentManager,
            listOf("Learn", "Practice", "Past Papers")
        )
        bottomNavAdapter.addFragment(VideosFragment.newInstance())
        bottomNavAdapter.addFragment(PracticeFragment.newInstance())
        bottomNavAdapter.addFragment(PastPapersFragment.newInstance())
        binding.viewpager.adapter = bottomNavAdapter
        binding.tabLayout.setupWithViewPager(binding.viewpager)
        binding.viewpager.offscreenPageLimit = bottomNavAdapter.count - 1
    }
//
//    @SuppressLint("InflateParams")
//    private fun setViewPager() {
//        bottomNavAdapter = DashboardBottomNavAdapter(supportFragmentManager, listOf())
//        bottomNavAdapter.addFragment(StreaksFragment.newInstance())
//        bottomNavAdapter.addFragment(BookmarksFragment.newInstance())
//        bottomNavAdapter.addFragment(ProfileFragment.newInstance())
//        bottomNavAdapter.addFragment(HomeFragment.newInstance())
//        binding.viewpager.adapter = bottomNavAdapter
//        binding.viewpager.offscreenPageLimit = bottomNavAdapter.count - 1
//        binding.bottomNavView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_home -> {
//                    binding.viewpager.currentItem = 0
//                }
//                R.id.nav_streaks -> {
//                    binding.viewpager.currentItem = 1
//                }
//                R.id.nav_bookmarks -> {
//                    binding.viewpager.currentItem = 2
//                }
//                R.id.nav_profile -> {
//                    binding.viewpager.currentItem = 3
//                }
//            }
//            return@setOnItemSelectedListener true
//        }
//        binding.viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                when (position) {
//                    0 -> binding.bottomNavView.menu.findItem(R.id.nav_home).isChecked = true
//                    1 -> binding.bottomNavView.menu.findItem(R.id.nav_streaks).isChecked = true
//                    2 -> binding.bottomNavView.menu.findItem(R.id.nav_bookmarks).isChecked = true
//                    3 -> binding.bottomNavView.menu.findItem(R.id.nav_profile).isChecked = true
//                }
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//            }
//
//        })
//    }

}