package com.example.iadesocial.data

data class Post(
    val postId: Int,
    val userID: Int,
    val username: String,
    val content: String,
    val imageUrl: String? = null
)

fun samplePost(): Post {
    val user = sampleUser()
    return ( Post(1,user.userId,user.username,"This is my first post","@drawable/ic_background"))
}

fun samplePosts(): List<Post> {
    val user = sampleUsers()
    return listOf(
        Post(1,user[0].userId, user[0].username, "This is my first post! lets see how long i can make this!", "@drawable/ic_background"),
        Post(2,user[1].userId, user[1].username, "Hello everyone!", "@drawable/ic_background"),
        Post(3,user[2].userId, user[2].username, "I love programming!", "@drawable/ic_background"),
        Post(4,user[0].userId, user[0].username, "Hello everyone!", "@drawable/ic_background"),
        Post(5,user[1].userId, user[1].username, "I love Donuts!", "@drawable/ic_background"),
        Post(6,user[2].userId, user[2].username, "This is my first post!", "@drawable/ic_background"),
    )
}

/*fun samplePosts(): List<Post> {
    val user = sampleUser()
    return listOf(
        Post(1,user.userId, user.username, "This is my first post! lets see how long i can make this!", "@drawable/ic_background"),
        Post(2,user.userId, user.username, "Hello everyone!", "@drawable/ic_background"),
        Post(3,user.userId, user.username, "I love programming!", "@drawable/ic_background"),
        Post(4,user.userId, user.username, "Hello everyone!", "@drawable/ic_background"),
        Post(5,user.userId, user.username, "I love Donuts!", "@drawable/ic_background"),
        Post(6,user.userId, user.username, "This is my first post!", "@drawable/ic_background"),
    )
}*/

/*fun samplePosts(): List<Post> {
    var c = 1
    val user = sampleUsers()
    val posts: MutableList<Post> = List(6) { samplePost() }.toMutableList()

    while(c <= 6){
        posts[c] = Post(c,user[c].userId, user[c].username, "This is my first post! lets see how long i can make this!", "@drawable/ic_background")
        c += 1
    }

    return posts
}*/
