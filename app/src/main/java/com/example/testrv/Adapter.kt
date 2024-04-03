package com.example.testrv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(private val feelings: List<Feelings>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
       private val feelingImage1: ImageView = itemView.findViewById(R.id.imageView1)
       private val  feelingText1: TextView = itemView.findViewById(R.id.textView1)


        fun bind(feelings: Feelings) {
            Picasso.get().load(feelings.image).into(feelingImage1)
            feelingText1.text = feelings.title


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feeling = feelings[position]
        holder.bind(feeling)
    }
    override fun getItemCount(): Int {
        return feelings.size
    }
}