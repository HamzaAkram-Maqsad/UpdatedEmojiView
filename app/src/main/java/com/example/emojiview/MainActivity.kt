package com.example.emojiview

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.emojiview.databinding.SampleCollapsingAnimationBinding
import com.example.emojiview.fragments.PastPapersFragment
import com.example.emojiview.fragments.PracticeFragment
import com.example.emojiview.fragments.VideosFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavAdapter: DashboardBottomNavAdapter
    private lateinit var binding: SampleCollapsingAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SampleCollapsingAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        changeStatusBarColor()
        setViewPager()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.course_appbar_menu, menu)
        val menuItem = menu?.findItem(R.id.searchIcon)
        val searchView = menuItem?.actionView as SearchView
        searchView.queryHint = "Type here to search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.e("submitted", query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e("Text changed", newText.toString())
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
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