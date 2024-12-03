package com.example.iadesocial.data.models.entities

data class Follower(
    val followerID: Int? = null,
    val profile: Profile,
    val followerProfile: Profile
)
