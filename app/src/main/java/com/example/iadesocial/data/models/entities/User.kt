package com.example.iadesocial.data.models.entities

data class User(
    val userID: Int? = null,
    val username: String,
    val email: String,
    val password: String,
    val name: String,
    val studentID: Int,
    val profile: Profile
)