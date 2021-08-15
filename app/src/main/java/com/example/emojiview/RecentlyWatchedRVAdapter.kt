package com.example.emojiview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecentlyWatchedRVAdapter(
    private val context: Context,
    private val list: List<RecentModel>
) : RecyclerView.Adapter<RecentlyWatchedRVAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentlyWatchedRVAdapter.MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recently_watched_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentlyWatchedRVAdapter.MyViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title: TextView? = null
        var card: CardView? = null

        init {
            title = itemView.findViewById(R.id.title)
            card = itemView.findViewById(R.id.mainCardView)
        }

        @SuppressLint("SetTextI18n")
        fun bind(course: RecentModel) {
            title?.text = course.title
            card?.setCardBackgroundColor(
                ColorStateList.valueOf(ContextCompat.getColor(context, course.color)))
        }
    }

}