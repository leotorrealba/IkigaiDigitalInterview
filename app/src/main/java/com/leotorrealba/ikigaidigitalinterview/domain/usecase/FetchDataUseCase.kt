package com.leotorrealba.ikigaidigitalinterview.domain.usecase

import com.leotorrealba.ikigaidigitalinterview.data.model.CreatePostRequest
import com.leotorrealba.ikigaidigitalinterview.domain.repository.DataRepository
import javax.inject.Inject

class FetchDataUseCase @Inject constructor(
    private val dataRepository: DataRepository
){
    suspend fun getPosts() = dataRepository.getPosts()

    suspend fun createPost(post: CreatePostRequest) = dataRepository.createPost(post)

}