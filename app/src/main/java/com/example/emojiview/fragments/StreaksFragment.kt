package com.example.emojiview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.emojiview.R
import com.example.emojiview.RecentModel
import com.example.emojiview.RecentlyWatchedRVAdapter
import com.example.emojiview.databinding.FragmentStreaksBinding

class StreaksFragment : Fragment() {

    private lateinit var binding: FragmentStreaksBinding

    companion object {
        fun newInstance() = StreaksFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStreaksBinding.inflate(inflater, container, false)

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
        binding.scrollableContent.apply {
            adapter = RecentlyWatchedRVAdapter(requireContext(), list2)
        }
        return binding.root
    }
}