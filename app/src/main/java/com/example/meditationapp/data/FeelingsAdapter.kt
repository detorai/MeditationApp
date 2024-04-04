package com.example.meditationapp.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationapp.R
import com.squareup.picasso.Picasso

class FeelingsAdapter (private val feelings: List<Feelings>): RecyclerView.Adapter<FeelingsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val feelingImage: ImageView = itemView.findViewById(R.id.imageForFeeling)
        private val  feelingText: TextView = itemView.findViewById(R.id.textForFeeling)


        fun bind(feelings: Feelings) {
            Picasso.get().load(feelings.image).into(feelingImage)
            feelingText.text = feelings.title


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feelings, parent, false)
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