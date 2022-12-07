package com.example.tpandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UnsplashModel(val urls: Urls, val title: String, val author: String, val description: String, val action1: String, val action2: String, val liked: Boolean): Parcelable