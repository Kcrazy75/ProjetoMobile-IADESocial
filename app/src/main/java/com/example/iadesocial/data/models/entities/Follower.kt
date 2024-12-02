package com.example.iadesocial.data.models.entities

data class Follower(
    val followerID: Int,
    val profile: Profile,
    val followerProfile: Profile
)
