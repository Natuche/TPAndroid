package com.example.tpandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UnsplashModel(
    val urls: Urls,
    val user: user,
    val description: String?,
    val likes: Int,
    val downloads: Int,
    var liked: Boolean
) : Parcelable