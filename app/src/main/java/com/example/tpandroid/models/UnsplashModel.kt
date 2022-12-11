package com.example.tpandroid.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UnsplashModel(
    val id: String,
    val urls: Urls,
    val user: user,
    val description: String?,
    val likes: Int,
    val downloads: Int,
    var liked_by_user: Boolean,
) : Parcelable