package com.example.emojiview.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emojiview.R

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
        var checkBox: CheckBox? = null
        var progressView: View? = null

        init {
            title = itemView.findViewById(R.id.subjectListItemTitle)
            innerRecyclerView = itemView.findViewById(R.id.subjectListItemRV)
            checkBox = itemView.findViewById(R.id.checkBox)
            progressView = itemView.findViewById(R.id.progress_bar)
        }

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
//            title?.text = topic.name
            if (position <= 1) {
                checkBox?.isChecked = true
                progressView?.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.cardBackground1
                    )
                )
            } else {
                checkBox?.isChecked = false
                progressView?.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        android.R.color.darker_gray
                    )
                )
            }
            innerRecyclerView?.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter =
                    SubjectInnerRVAdapter(context, listOf())
            }
        }
    }
}