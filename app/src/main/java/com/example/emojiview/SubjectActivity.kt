package com.example.emojiview

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.emojiview.databinding.ActivitySubjectBinding
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener


class SubjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubjectBinding
    private var currentOffset = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeStatusBarColor()

        val list2 = listOf(
            RecentModel("1a - Primes HCF and LCM", R.color.colorPrimary),
            RecentModel("2a - Decimals", R.color.secondaryColor),
            RecentModel("3a - Round off Approximation", R.color.tertiaryColor),
            RecentModel("3b - Round off Approximation", R.color.fourthColor),
            RecentModel("1a - Primes HCF and LCM", R.color.colorPrimary),
            RecentModel("2a - Decimals", R.color.secondaryColor),
            RecentModel("3a - Round off Approximation", R.color.tertiaryColor),
            RecentModel("3b - Round off Approximation", R.color.fourthColor),
            RecentModel("1a - Primes HCF and LCM", R.color.colorPrimary),
            RecentModel("2a - Decimals", R.color.secondaryColor),
            RecentModel("3a - Round off Approximation", R.color.tertiaryColor),
            RecentModel("3b - Round off Approximation", R.color.fourthColor),
            RecentModel("1a - Primes HCF and LCM", R.color.colorPrimary),
            RecentModel("2a - Decimals", R.color.secondaryColor),
            RecentModel("3a - Round off Approximation", R.color.tertiaryColor),
            RecentModel("3b - Round off Approximation", R.color.fourthColor),
        )
        binding.recentlyWatchedRecyclerView.apply {
            adapter = RecentlyWatchedRVAdapter(this@SubjectActivity, list2)
        }
        Log.e("Not touched offset", binding.appbar.totalScrollRange.toString())
        binding.appbar.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.e("offsetooos", verticalOffset.toString())
            Log.e("Not touched offset2", binding.appbar.totalScrollRange.toString())
//            if (abs(verticalOffset) >= appBarLayout.totalScrollRange && binding.collapsedCardLayout.visibility != View.VISIBLE) {
//                // Collapsed
            val percentage =
                (binding.appbar.totalScrollRange + verticalOffset).numberToPercentage(binding.appbar.totalScrollRange)
//            if (currentOffset != verticalOffset) {
////                TransitionManager.beginDelayedTransition(binding.subjectCard, AutoTransition())
//                Log.e("percentage", percentage.toString())
//                val params = binding.subjectCard.layoutParams
//                val dp140 = resources.getDimension(R.dimen._140sdp).toInt()
//                val dp40 = resources.getDimension(R.dimen._40sdp).toInt()
//                Log.e("dp140", dp140.toString())
//
//                val height = if(percentage == 0f) dp40 else percentage.percentageToNumber(dp140)
//                Log.e("height", height.toString())
//                params.height = height
//                binding.subjectCard.layoutParams = params
//            }
            currentOffset = verticalOffset
//                binding.collapsedCardLayout.makeVisible()
//                binding.expandedCardLayout.makeGone()
////                Log.e("appBarHeight", binding.appbar.height.toString())
////                Log.e("40sdp", sdpToPx(resources.getDimension(R.dimen._40sdp)).toString())
//            } else if (verticalOffset == 0 && binding.expandedCardLayout.visibility != View.VISIBLE) {
//                val params = binding.subjectCard.layoutParams
//                params.height = resources.getDimension(R.dimen._140sdp).toInt()
//                binding.subjectCard.layoutParams = params
//                binding.collapsedCardLayout.makeGone()
//                binding.expandedCardLayout.makeVisible()
////                Log.e("appBarHeight", binding.appbar.height.toString())
////                Log.e("140sdp", sdpToPx(resources.getDimension(R.dimen._140sdp)).toString())
//                // Expanded
//            } else {
//                // Somewhere in between
//            }
//            if (verticalOffset == -binding.col.height + binding.toolbar.height) {
//                Log.e("collapsed", "true")
//                val params = binding.subjectCard.layoutParams
//                params.height = resources.getDimension(R.dimen._40sdp).toInt()
//                binding.subjectCard.layoutParams = params
//                binding.collapsedCardLayout.makeVisible()
//                binding.expandedCardLayout.makeGone()
//                //toolbar is collapsed here
//            } else if (verticalOffset == 0) {
//                Log.e("collapsed", "false")
//                val params = binding.subjectCard.layoutParams
//                params.height = resources.getDimension(R.dimen._140sdp).toInt()
//                binding.subjectCard.layoutParams = params
//                binding.collapsedCardLayout.makeGone()
//                binding.expandedCardLayout.makeVisible()
//            }
        })
    }
}