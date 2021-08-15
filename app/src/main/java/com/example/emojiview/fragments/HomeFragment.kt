package com.example.emojiview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.emojiview.*
import com.example.emojiview.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val list = listOf(
            CourseModel("O-Level\nMath", R.drawable.ic_maths, 55, R.color.colorPrimary),
            CourseModel("MCAT\nChemistry", R.drawable.ic_chemistry, 87, R.color.secondaryColor),
            CourseModel("MCAT\nBiology", R.drawable.ic_biology, 98, R.color.tertiaryColor),
            CourseModel("MCAT\nPhysics", R.drawable.ic_physics, 43, R.color.fourthColor),
            CourseModel("O-Level\nMath", R.drawable.ic_maths, 55, R.color.colorPrimary),
            CourseModel("MCAT\nChemistry", R.drawable.ic_chemistry, 87, R.color.secondaryColor),
            CourseModel("MCAT\nBiology", R.drawable.ic_biology, 98, R.color.tertiaryColor),
            CourseModel("MCAT\nPhysics", R.drawable.ic_physics, 43, R.color.fourthColor),
        )
        val list2 = listOf(
            RecentModel("1a - Primes HCF and LCM", R.color.colorPrimary),
            RecentModel("2a - Decimals", R.color.secondaryColor),
            RecentModel("3a - Round off Approximation", R.color.tertiaryColor),
//            RecentModel("3b - Round off Approximation", R.color.fourthColor),
        )
        binding.coursesRecyclerView.apply {
            adapter = CoursesRVAdapter(requireContext(), list)
        }

        binding.recentlyWatchedRecyclerView.apply {
            adapter = RecentlyWatchedRVAdapter(requireContext(), list2)
        }
        return binding.root
    }

}