package com.example.iadesocial.data.models.entities

data class Post(
    val postID: Int? = null,
    val profile: Profile,
    val picture: String,
    val content: String,
    var comments: List<Comment>,
    var likes: List<Like>
)