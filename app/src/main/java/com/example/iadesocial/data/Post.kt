package com.example.iadesocial.data

data class Post(
    val userID: String,
    val username: String,
    val content: String,
    val imageUrl: String? = null
)
