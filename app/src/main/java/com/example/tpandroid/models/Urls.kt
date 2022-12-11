package com.example.tpandroid.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
) : Parcelable {

}
