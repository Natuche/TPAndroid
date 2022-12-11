package com.example.tpandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tpandroid.models.UnsplashModel

class UnsplashAdaptater (private val cellClickListener: CellClickListener, private  val likeClickListener: LikeClickListener) : RecyclerView.Adapter<UnsplashAdaptater.ViewHolder>() {

    var mList: List<UnsplashModel> = listOf()
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_card, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val unsplashCard = mList[position]
        Glide.with(holder.itemView)
            .load(unsplashCard.urls.regular)
            .into(holder.image)

        holder.secondary.text = unsplashCard.user.username
        holder.description.text = unsplashCard.description
        if(unsplashCard.liked_by_user) holder.liked.setImageResource(R.drawable.favorite_red)
        else holder.liked.setImageResource(R.drawable.favorite_red_outlined)

        holder.liked.setOnClickListener {
            likeClickListener.onLikeClickListener(unsplashCard)
        }

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
        val secondary: TextView = itemView.findViewById(R.id.secondary)
        val description: TextView = itemView.findViewById(R.id.description)
        val liked: ImageView = itemView.findViewById(R.id.like)
    }
}
