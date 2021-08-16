package com.example.emojiview.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emojiview.R

class SubjectInnerRVAdapter(
    private val context: Context,
    private val list: List<String>
) : RecyclerView.Adapter<SubjectInnerRVAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectInnerRVAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.video_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectInnerRVAdapter.MyViewHolder, position: Int) {
//        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return 12 // list.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title: TextView? = null
        var image: ImageView? = null
        var duration: TextView? = null

        init {
            title = itemView.findViewById(R.id.videoItemTitle)
            image = itemView.findViewById(R.id.videoItemImage)
            duration = itemView.findViewById(R.id.videoItemDuration)
        }

        @SuppressLint("SetTextI18n")
        fun bind(video: String) {
//            title?.text = topic.name

        }
    }
}