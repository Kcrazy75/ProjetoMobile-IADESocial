package com.example.iadesocial.data

data class Like(
    val likeId: Int,
    val postId: Int,
    val userId: Int,
    val dateCreated: String
)
