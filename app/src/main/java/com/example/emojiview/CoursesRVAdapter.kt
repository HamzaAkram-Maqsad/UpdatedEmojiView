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
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CoursesRVAdapter(
    private val context: Context,
    private val list: List<CourseModel>
) : RecyclerView.Adapter<CoursesRVAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoursesRVAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.course_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoursesRVAdapter.MyViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title: TextView? = null
        var image: ImageView? = null
        var progressBar: ProgressBar? = null

        init {
            title = itemView.findViewById(R.id.courseTitle)
            image = itemView.findViewById(R.id.courseImageView)
            progressBar = itemView.findViewById(R.id.courseProgressBar)
        }

        @SuppressLint("SetTextI18n")
        fun bind(course: CourseModel) {
            title?.text = course.title
            image?.setImageResource(course.image)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                progressBar?.setProgress(course.progress, true)
            } else {
                progressBar?.progress = course.progress
            }
            progressBar?.progressTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, course.progressColor))
        }
    }
}