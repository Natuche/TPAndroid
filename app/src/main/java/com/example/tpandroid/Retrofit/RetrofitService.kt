package com.example.tpandroid.Retrofit

import com.example.tpandroid.models.LikedModel
import com.example.tpandroid.models.UnsplashModel
import retrofit2.http.*

interface RetrofitService {
    @GET("/photos/random")
    suspend fun getRandomPhotos(@Query("client_id")accessKey:String, @Query("count")count:Int): List<UnsplashModel>

    @GET("/users/{username}")
    suspend fun getUser(@Path("user") username: String, @Query("client_id")accessKey:String): UserModel

    @POST("/photos/{id}/like")
    @Headers("Authorization: Bearer btwOfVURw2GZWxG_5CY9zJRX2Nn_Qey0FrtBEdz25zg")
    suspend fun postLike(@Path("id") id: String, @Query("client_id")accessKey: String): LikedModel
}