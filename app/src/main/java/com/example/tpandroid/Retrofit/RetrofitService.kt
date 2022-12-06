package com.example.tpandroid.Retrofit

import retrofit2.http.GET

interface RetrofitService {
    @GET("/photos/random")
    suspend fun getRandomPhotos(): List<RandomPhotos>


}