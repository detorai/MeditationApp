package com.example.meditationapp.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationapp.R
import com.squareup.picasso.Picasso

class QuotesAdapter (private val quotes: List<Quotes>): RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val quotesImage: ImageView = itemView.findViewById(R.id.IFB1)
        private val  quotesText1: TextView = itemView.findViewById(R.id.HB1)
        private val  quotesText2: TextView = itemView.findViewById(R.id.ST1)


        fun bind(quotes: Quotes) {
            quotesText1.text = quotes.title
            quotesText2.text = quotes.description
            Picasso.get().load(quotes.image).into(quotesImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quotes, parent, false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotes[position]
        holder.bind(quote)
    }
    override fun getItemCount(): Int {
        return quotes.size
    }
}