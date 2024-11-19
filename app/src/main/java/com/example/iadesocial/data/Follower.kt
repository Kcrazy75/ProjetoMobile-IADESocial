package com.example.iadesocial.data

data class Follower(
    val followerId: Int,    //ID da Relacao
    val userId: Int,        //ID do Seguidor
    val followerUserId: Int //ID do Seguido
)
