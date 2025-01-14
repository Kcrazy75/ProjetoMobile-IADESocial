package com.example.iadesocial.data

import com.example.iadesocial.data.models.entities.Comment
import com.example.iadesocial.data.models.entities.Follower
import com.example.iadesocial.data.models.entities.Like
import com.example.iadesocial.data.models.entities.Post
import com.example.iadesocial.data.models.entities.Profile
import com.example.iadesocial.data.models.entities.User

object SampleData {
    // Sample Profiles
    val profile1 = Profile(
        profileID = 1,
        name = "Kelvin Lamas",
        bio = "A tech enthusiast and avid coder.",
        profilePicture = "@drawable/ic_iade",
        posts = emptyList(),
        comments = emptyList(),
        followers = emptyList(),
        following = emptyList()
    )

    val profile2 = Profile(
        profileID = 2,
        name = "Jane Doe",
        bio = "Loves reading and exploring new places.",
        profilePicture = "@drawable/ic_iade",
        posts = emptyList(),
        comments = emptyList(),
        followers = emptyList(),
        following = emptyList()
    )

    val profile3 = Profile(
        profileID = 3,
        name = "John Smith",
        bio = "Musician and artist.",
        profilePicture = "@drawable/ic_iade",
        posts = emptyList(),
        comments = emptyList(),
        followers = emptyList(),
        following = emptyList()
    )

    val profile4 = Profile(
        profileID = 4,
        name = "Alice Brown",
        bio = "Fitness enthusiast and health coach.",
        profilePicture = "@drawable/ic_iade",
        posts = emptyList(),
        comments = emptyList(),
        followers = emptyList(),
        following = emptyList()
    )

    val profile5 = Profile(
        profileID = 5,
        name = "Bob White",
        bio = "Tech blogger and gamer.",
        profilePicture = "@drawable/ic_iade",
        posts = emptyList(),
        comments = emptyList(),
        followers = emptyList(),
        following = emptyList()
    )

    val profile6 = Profile(
        profileID = 6,
        name = "Carol Green",
        bio = "Travel and lifestyle blogger.",
        profilePicture = "@drawable/ic_iade",
        posts = emptyList(),
        comments = emptyList(),
        followers = emptyList(),
        following = emptyList()
    )

    // Sample Comments
    val comment1 = Comment(
        commentID = 1,
        post = Post(1,profile1,"@drawable/ic_postex1","This is comment 1",emptyList(),emptyList()),
        profile = profile2,
        content = "Great post, Kelvin!",
        likes = emptyList()
    )

    val comment2 = Comment(
        commentID = 2,
        post = Post(2, profile2, "@drawable/ic_postex2","This is comment 2", emptyList(), emptyList()),
        profile = profile1,
        content = "Interesting insights, Jane!",
        likes = emptyList()
    )

    // Sample Likes
    val like1 = Like(
        likeID = 1,
        profile = profile1,
        post = null,
        comment = comment2
    )

    val like2 = Like(
        likeID = 2,
        profile = profile2,
        post = null,
        comment = comment1
    )

    // Sample Posts
    val post1 = Post(
        postID = 1,
        profile = profile1,
        picture = "@drawable/ic_postex1",
        content = "This is post ",
        comments = listOf(comment1, comment2),
        likes = listOf(like1, like2)
    )

    val post2 = Post(
        postID = 2,
        profile = profile2,
        picture = "@drawable/ic_postex2",
        content = "This is post 2",
        comments = listOf(comment1, comment2),
        likes = listOf(like1, like2)
    )

    // Create more posts for each profile
    val postsForProfile1 = List(6) { post1.copy(postID = it + 1, content = "This is post ${it + 1}") }
    val postsForProfile2 = List(6) { post2.copy(postID = it + 7, content = "This is post ${it + 1}") }
    val postsForProfile3 = List(6) { post1.copy(postID = it + 13,content = "This is post ${it + 1}") }
    val postsForProfile4 = List(6) { post2.copy(postID = it + 19,content = "This is post ${it + 1}") }
    val postsForProfile5 = List(6) { post1.copy(postID = it + 25,content = "This is post ${it + 1}") }
    val postsForProfile6 = List(6) { post2.copy(postID = it + 31,content = "This is post ${it + 1}") }

    // Update profiles with posts
    val updatedProfile1 = profile1.copy(posts = postsForProfile1)
    val updatedProfile2 = profile2.copy(posts = postsForProfile2)
    val updatedProfile3 = profile3.copy(posts = postsForProfile3)
    val updatedProfile4 = profile4.copy(posts = postsForProfile4)
    val updatedProfile5 = profile5.copy(posts = postsForProfile5)
    val updatedProfile6 = profile6.copy(posts = postsForProfile6)

    // Sample Followers
    val followers = listOf(
        Follower(1, updatedProfile1, updatedProfile2),
        Follower(2, updatedProfile1, updatedProfile3),
        Follower(3, updatedProfile2, updatedProfile1),
        Follower(4, updatedProfile2, updatedProfile3),
        Follower(5, updatedProfile3, updatedProfile1),
        Follower(6, updatedProfile3, updatedProfile2)
    )

    // Update profiles with followers
    val profiles = listOf(
        updatedProfile1.copy(
            followers = followers.filter { it.followerProfile == updatedProfile1 },
            following = followers.filter { it.profile == updatedProfile1 }
        ),
        updatedProfile2.copy(
            followers = followers.filter { it.followerProfile == updatedProfile2 },
            following = followers.filter { it.profile == updatedProfile2 }
        ),
        updatedProfile3.copy(
            followers = followers.filter { it.followerProfile == updatedProfile3 },
            following = followers.filter { it.profile == updatedProfile3 }
        ),
        updatedProfile4.copy(
            followers = followers.filter { it.followerProfile == updatedProfile4 },
            following = followers.filter { it.profile == updatedProfile4 }
        ),
        updatedProfile5.copy(
            followers = followers.filter { it.followerProfile == updatedProfile5 },
            following = followers.filter { it.profile == updatedProfile5 }
        ),
        updatedProfile6.copy(
            followers = followers.filter { it.followerProfile == updatedProfile6 },
            following = followers.filter { it.profile == updatedProfile6 }
        )
    )

    // Sample Users
    val users = profiles.mapIndexed { index, profile -> User(
        userID = index + 1,
        username = profile.name.replace(" ", "").lowercase(),
        email = "${profile.name.replace(" ", "").lowercase()}@example.com",
        password = "password",
        name = profile.name,
        studentID = 2024 + index,
        profile = profile )
    }

    // Adding comments and likes to posts
    init {
        profiles.forEach { profile ->
            profile.posts.forEach { post ->
                post.comments = profiles.filter { it != profile }.map { Comment(0, post, it, "Comment from ${it.name}", emptyList()) }
                post.likes = profiles.filter { it != profile }.map { Like(0, it, post, null) }
            }
        }
    }
}