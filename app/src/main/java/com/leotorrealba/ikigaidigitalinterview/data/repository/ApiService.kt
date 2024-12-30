package com.leotorrealba.ikigaidigitalinterview.data.repository

import com.leotorrealba.ikigaidigitalinterview.data.model.CreatePostRequest
import com.leotorrealba.ikigaidigitalinterview.data.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("post")
    suspend fun getPost(): Response<Post>?

    @POST("post")
    suspend fun createPost(@Body post: CreatePostRequest): Response<Post>

}