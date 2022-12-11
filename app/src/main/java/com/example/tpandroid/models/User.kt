package com.example.tpandroid.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class user (
    val id: String,
    val updated_at: String,
    val username: String,
    val name: String,
    val total_likes: String,
    val total_photos: String,
    val total_collections: String
) : Parcelable
