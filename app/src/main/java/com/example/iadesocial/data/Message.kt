package com.example.iadesocial.data

data class Message(
    val messageId: Int,
    val senderUserId: Int,
    val receiverUserId: Int,
    val content: String,
    val dateSent: String
)
