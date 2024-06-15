package com.example.meditationapp.data

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.provider.ContactsContract.Contacts.Photo
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationapp.R
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Date
class PhotoAdapter(private val context: Context, private val images: List<Uri>) : RecyclerView.Adapter<PhotoAdapter.ImageViewHolder>() {
    private val _images = images.toMutableList()
    var onClickButton: (() -> Unit)? = null
    var onClickImage: ((Uri) -> Unit)? = null

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.photos)
        val textView: TextView = itemView.findViewById(R.id.time_dwn)
        fun bind(imageUri: Uri) {
            imageView.setImageURI(imageUri)
        }
    }
    @SuppressLint("SimpleDateFormat")
    private fun getCurrentData(): String {
        val sdf = SimpleDateFormat("HH:mm")
        return sdf.format(Date())
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_photos, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(_images[position])
        if (position == _images.lastIndex){
            holder.imageView.setOnClickListener {
                if (onClickButton != null){
                    onClickButton!!()
                }
            }

        } else {
            holder.textView.text=getCurrentData()
        }
                if (position != _images.lastIndex){
                    holder.imageView.setOnClickListener {
                        if (onClickImage != null){
                            onClickImage!!(_images[position])
                        }
                    }
                } else {
                    Log.d("Click!!", "Ошибка")
                }
    }

    override fun getItemCount(): Int {
        return _images.size
    }

    fun addItem(uri: Uri){
        _images.add(0, uri)
        notifyItemInserted(0)
    }
}

