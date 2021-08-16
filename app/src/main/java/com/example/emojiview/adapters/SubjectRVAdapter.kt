package com.example.emojiview.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emojiview.R
import com.example.emojiview.makeGone
import com.example.emojiview.makeVisible

class SubjectRVAdapter(
    private val context: Context,
    private val list: List<String>
) : RecyclerView.Adapter<SubjectRVAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectRVAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.subject_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectRVAdapter.MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 12 // list.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title: TextView? = null
        var innerRecyclerView: RecyclerView? = null
        var progressBar: ProgressBar? = null
        var progressView: View? = null
        var completeTick: ImageView? = null

        init {
            title = itemView.findViewById(R.id.subjectListItemTitle)
            innerRecyclerView = itemView.findViewById(R.id.subjectListItemRV)
            progressBar = itemView.findViewById(R.id.progressBar)
            progressView = itemView.findViewById(R.id.progress_bar)
            completeTick = itemView.findViewById(R.id.completeTick)
        }

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
//            title?.text = topic.name
            if (position <= 1) {
                progressBar?.progress = 100
                completeTick?.makeVisible()
                progressView?.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            } else {
                progressBar?.progress = 67
                completeTick?.makeGone()
                progressView?.setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
            }
            innerRecyclerView?.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter =
                    SubjectInnerRVAdapter(context, listOf())
            }
        }
    }
}