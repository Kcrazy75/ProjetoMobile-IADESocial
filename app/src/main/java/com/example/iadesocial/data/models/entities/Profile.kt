package com.example.iadesocial.data.models.entities

data class Profile(
    val profileID: Int? = null,
    val name: String,
    val bio: String,
    val profilePicture: String,
    var posts: List<Post>,
    var comments: List<Comment>,
    var followers: List<Follower>,
    var following: List<Follower>
)
