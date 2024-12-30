package com.leotorrealba.ikigaidigitalinterview.data.model

data class Post(
    val authorId: String,
    val authorName: String,
    val content: String,
    val postId: String
)

data class CreatePostRequest(
    val authorId: String,
    val authorName: String,
    val content: String,
    val postId: String
)