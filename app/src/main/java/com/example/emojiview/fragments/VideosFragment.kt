package com.example.emojiview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emojiview.adapters.SubjectRVAdapter
import com.example.emojiview.databinding.FragmentVideosBinding

class VideosFragment : Fragment() {

    companion object {
        fun newInstance() = VideosFragment()
    }

    private lateinit var binding: FragmentVideosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideosBinding.inflate(inflater, container, false)
        initViews()
//        addOnServerResponseListener()
//        viewModel.fetchData(activity.getSelectedCourseId())
        return binding.root
    }

    private fun initViews() {
        binding.videosRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context)
            adapter = SubjectRVAdapter(context, listOf())
        }
    }
}