package com.example.tpandroid.Retrofit

import com.example.tpandroid.UnsplashModel
import retrofit2.http.*

interface RetrofitService {
    @GET("/photos/random")
    suspend fun getRandomPhotos(@Query("client_id")accessKey:String, @Query("count")count:Int): List<UnsplashModel>

    @GET("/users/{username}")
    suspend fun getUser(@Path("user") username: String, @Query("client_id")accessKey:String): UserModel

    @POST("/photos/{id}/like")
    @Headers("Authorization: Bearer c8tyvd8fUAAoMUAo6EAlxqABIjHYrNUzmwj2VJ3n_to")
    suspend fun postLike(@Path("id") id: String, @Query("client_id")accessKey: String): UnsplashModel
}