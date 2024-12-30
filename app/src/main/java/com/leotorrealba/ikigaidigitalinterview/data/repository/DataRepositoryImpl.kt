package com.leotorrealba.ikigaidigitalinterview.data.repository

import com.leotorrealba.ikigaidigitalinterview.data.model.CreatePostRequest
import com.leotorrealba.ikigaidigitalinterview.data.model.Post
import com.leotorrealba.ikigaidigitalinterview.domain.repository.DataRepository
import retrofit2.Response

import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val apiService: ApiService) : DataRepository {

    override suspend fun getPosts(): Result<Post> {

        return Result.success(apiService.getPost()?.body() ?: throw Exception("Error fetching posts"))
    }

    override suspend fun createPost(post: CreatePostRequest): Result<Post> {
        return Result.success(apiService.createPost(post).body() ?: throw Exception(""))
    }

}