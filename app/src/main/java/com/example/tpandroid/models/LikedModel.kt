package com.example.tpandroid.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LikedModel(
    val photo: UnsplashModel,
    val user: user,
) : Parcelable