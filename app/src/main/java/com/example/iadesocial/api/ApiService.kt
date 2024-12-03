package com.example.iadesocial.api

import com.example.iadesocial.data.models.entities.Comment
import com.example.iadesocial.data.models.entities.Follower
import com.example.iadesocial.data.models.entities.Like
import com.example.iadesocial.data.models.entities.Post
import com.example.iadesocial.data.models.entities.Profile
import com.example.iadesocial.data.models.entities.User
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    //Login and Sign-up
    @POST("users/login")
    fun loginUser(@Query("username") username: String, @Query("password") password: String): Call<User>

    @POST("users/signup")
    fun signUpUser(@Body user: User): Call<User>


    // User Endpoints
    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: Int): Call<User>

    @POST("users")
    fun createUser(@Body user: User): Call<User>

    @PUT("users/{id}")
    fun updateUser(@Body user: User, @Path("id") id: Int): Call<User>

    @DELETE("users/{id}")
    fun deleteUserById(@Path("id") id: Int): Call<Void>


    // Profile Endpoints
    @GET("profiles")
    fun getAllProfiles(): Call<List<Profile>>

    @GET("profiles/{id}")
    fun getProfileById(@Path("id") id: Int): Call<Profile>

    @POST("profiles")
    fun createProfile(@Body profile: Profile): Call<Profile>

    @PUT("profiles/{id}")
    fun updateProfile(@Body profile: Profile, @Path("id") id: Int): Call<Profile>

    @DELETE("profiles/{id}")
    fun deleteProfileById(@Path("id") id: Int): Call<Void>


    // Post Endpoints
    @GET("posts")
    fun getAllPosts(): Call<List<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>

    @POST("posts")
    fun createPost(@Body post: Post): Call<Post>

    @PUT("posts/{id}")
    fun updatePost(@Body post: Post, @Path("id") id: Int): Call<Post>

    @DELETE("posts/{id}")
    fun deletePostById(@Path("id") id: Int): Call<Void>


    // Comment Endpoints
    @GET("comments")
    fun getAllComments(): Call<List<Comment>>

    @GET("comments/{id}")
    fun getCommentById(@Path("id") id: Int): Call<Comment>

    @POST("comments")
    fun createComment(@Body comment: Comment): Call<Comment>

    @PUT("comments/{id}")
    fun updateComment(@Body comment: Comment, @Path("id") id: Int): Call<Comment>

    @DELETE("comments/{id}")
    fun deleteCommentById(@Path("id") id: Int): Call<Void>


    // Like Endpoints
    @GET("likes")
    fun getAllLikes(): Call<List<Like>>

    @GET("likes/{id}")
    fun getLikeById(@Path("id") id: Int): Call<Like>

    @POST("likes")
    fun createLike(@Body like: Like): Call<Like>

    @PUT("likes/{id}")
    fun updateLike(@Body like: Like, @Path("id") id: Int): Call<Like>

    @DELETE("likes/{id}")
    fun deleteLikeById(@Path("id") id: Int): Call<Void>


    // Follower Endpoints
    @GET("followers")
    fun getAllFollowers(): Call<List<Follower>>

    @GET("followers/{id}")
    fun getFollowerById(@Path("id") id: Int): Call<Follower>

    @POST("followers")
    fun createFollower(@Body follower: Follower): Call<Follower>

    @PUT("followers/{id}")
    fun updateFollower(@Body follower: Follower, @Path("id") id: Int): Call<Follower>

    @DELETE("followers/{id}")
    fun deleteFollowerById(@Path("id") id: Int): Call<Void>
}
