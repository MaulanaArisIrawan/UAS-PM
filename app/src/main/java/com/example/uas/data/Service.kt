package com.example.uas.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface Service {
    @GET("posts?userId=1")
    fun getPost(): Single<ResponseApi>

    @POST("posts")
    fun addPost(@retrofit2.http.Body bodyPost: Body): Single<ResponseApi.ResponseApiItem>

    @PUT("posts/{id}")
    fun putPost(
        @retrofit2.http.Body bodyPost: BodyPatch,
        @Path("id") id: Int
    ): Single<ResponseApi.ResponseApiItem>

    @PATCH("posts/{id}")
    fun patchPost(@retrofit2.http.Body body: HashMap<String, String>): Single<ResponseApi.ResponseApiItem>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int): Single<ResponseApi.ResponseApiItem>
}