package com.example.tpandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UnsplashModel(val urls: Urls, val title: String, val user: user, val description: String, val likes: Int, val action2: String, val liked: Boolean): Parcelable