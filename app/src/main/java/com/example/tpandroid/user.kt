package com.example.tpandroid

import android.os.Parcelable
import androidx.annotation.Nullable
import kotlinx.android.parcel.Parcelize

@Parcelize
class user (
    val id: String,
    val updated_at: String,
    val username: String,
    val name: String,
    val total_likes: String,
    val total_photos: String,
    val total_collections: String
) : Parcelable {

}
