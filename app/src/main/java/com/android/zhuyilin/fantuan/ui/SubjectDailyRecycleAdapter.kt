package com.android.zhuyilin.fantuan.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.android.zhuyilin.fantuan.R
import com.android.zhuyilin.fantuan.model.Subject
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Locale.CHINA

class SubjectDailyRecycleAdapter(val subjects: List<Subject>, val context: Context) : RecyclerView.Adapter<SubjectDailyRecycleAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val subject = subjects[position]
        holder.titleView.text = subject.title
        Picasso.with(context).load(subject.posterUrl).into(holder.postImage)
        holder.airTime.text = SimpleDateFormat("HH:mm", CHINA).format(subject.airtimeBeginAt)

        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subject_daily_recycle_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleView = itemView.findViewById<TextView>(R.id.subject_title)
        val postImage = itemView.findViewById<ImageView>(R.id.subject_post_image)
        val airTime = itemView.findViewById<TextView>(R.id.subject_airtime)
    }
}
