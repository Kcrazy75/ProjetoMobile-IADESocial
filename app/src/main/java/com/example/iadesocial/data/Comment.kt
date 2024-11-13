package com.example.iadesocial.data

data class Comment(
    val commentId: Int,
    val postId: Int,
    val userId: Int,
    val content: String,
    val dateCreated: String
)
