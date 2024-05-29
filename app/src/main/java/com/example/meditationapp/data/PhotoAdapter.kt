package com.example.meditationapp.data

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationapp.R
import com.squareup.picasso.Picasso

class PhotoAdapter(private val requireContext: Context, private val imageUris: MutableList<Uri>): RecyclerView.Adapter<PhotoAdapter.ViewHolder>()  {
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val photos: ImageView = itemView.findViewById(R.id.photos)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  imageUris.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUri = imageUris[position]
        Picasso.get().load(imageUri).into(holder.photos)
    }
}