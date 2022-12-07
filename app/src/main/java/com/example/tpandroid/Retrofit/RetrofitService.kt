package com.example.tpandroid.Retrofit

import com.example.tpandroid.UnsplashModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("/photos/random")
    suspend fun getRandomPhotos(@Query("client_id")accessKey:String, @Query("count")count:Int): List<UnsplashModel>


}