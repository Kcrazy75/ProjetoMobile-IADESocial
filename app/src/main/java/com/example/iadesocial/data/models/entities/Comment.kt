package com.example.iadesocial.data.models.entities

data class Comment(
    val commentID: Int,
    val post: Post,
    val profile: Profile,
    val content: String,
    var likes: List<Like>
)
