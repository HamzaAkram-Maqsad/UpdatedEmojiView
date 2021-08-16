package com.example.emojiview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emojiview.adapters.SubjectRVAdapter
import com.example.emojiview.databinding.FragmentPastPapersBinding

class PastPapersFragment : Fragment() {

    companion object {
        fun newInstance() = PastPapersFragment()
    }

    private lateinit var binding: FragmentPastPapersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPastPapersBinding.inflate(inflater, container, false)
        initViews()
//        addOnServerResponseListener()
//        viewModel.fetchData(activity.getSelectedCourseId())
        return binding.root
    }

    private fun initViews() {
        binding.pastPapersRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context)
            adapter = SubjectRVAdapter(context, listOf())
        }
    }

}