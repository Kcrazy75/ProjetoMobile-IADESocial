package com.example.iadesocial.data

data class Comment(
    val commentId: Int,
    val postId: Int,
    val userId: Int,
    val content: String,
)

fun sampleComment(): Comment {
    return ( Comment(1,1,20220296,"This is my first comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"))
}

/*fun sampleComments(): List<Comment> {
    val user = sampleUsers()
    return listOf(
        Comment(1,1,user[0].userId,"This is my first comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(2,1,user[1].userId,"This is my second comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(3,1,user[2].userId,"This is my first comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(4,1,user[0].userId,"This is my second comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(5,1,user[1].userId,"This is my first comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(6,1,user[2].userId,"This is my second comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
    )
}*/

fun sampleComments(): List<Comment> {
    //val user = sampleUsers()
    return listOf(
        Comment(1,1,1,"This is my first comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(2,1,1,"This is my second comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(3,1,1,"This is my first comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(4,1,1,"This is my second comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(5,1,1,"This is my first comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
        Comment(6,1,1,"This is my second comment! Lets see how long i can make this! Maybe i can make it go all the way to the end"),
    )
}
