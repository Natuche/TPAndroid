package com.example.tpandroid

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class user (
    val id: String,
    val updated_at: String,
    val username: String,
    val name: String,
    val portfolio_url: String,
    val bio: String,
    val location: String,
    val total_likes: String,
    val total_photos: String,
    val total_collections: String,
    val instagram_username: String,
    val twitter_username: String
        ) : Parcelable {

}
