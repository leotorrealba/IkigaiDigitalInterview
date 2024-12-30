package com.leotorrealba.ikigaidigitalinterview.domain.repository

import com.leotorrealba.ikigaidigitalinterview.data.model.CreatePostRequest
import com.leotorrealba.ikigaidigitalinterview.data.model.Post
import kotlinx.coroutines.flow.Flow

interface DataRepository{

    //Get Posts
    suspend fun getPosts(): Result<Post>

    //Send Posts
    suspend fun createPost(post: CreatePostRequest): Result<Post>
}