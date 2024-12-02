package com.example.iadesocial.data.models.entities

data class Like(
    val likeID: Int,
    val profile: Profile,
    val post: Post?,
    val comment: Comment?
)
