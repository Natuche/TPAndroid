package com.example.tpandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class UnsplashAdaptater (private val mList: List<UnsplashModel>, private val cellClickListener: CellClickListener) : RecyclerView.Adapter<UnsplashAdaptater.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_card, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val unsplashCard = mList[position]

        // sets the text to the textview from our itemHolder class
        Glide.with(holder.itemView)
            .load(unsplashCard.imageUrl)
            .into(holder.image)

        holder.title.text = unsplashCard.title
        holder.secondary.text = unsplashCard.author
        holder.description.text = unsplashCard.description
        holder.action1.text = unsplashCard.action1

        if(!unsplashCard.liked )holder.action2.text = "Like"
        else holder.action2.text = "Unlike"

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(unsplashCard)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val secondary: TextView = itemView.findViewById(R.id.secondary)
        val description: TextView = itemView.findViewById(R.id.description)
        val action1: MaterialButton = itemView.findViewById(R.id.action1)
        val action2: MaterialButton = itemView.findViewById(R.id.action2)

    }
}
