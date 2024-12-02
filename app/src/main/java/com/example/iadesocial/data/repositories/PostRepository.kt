package com.example.iadesocial.data.repositories

import com.example.iadesocial.api.RetrofitInstance
import com.example.iadesocial.data.models.entities.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {
    fun getPosts(onResult: (List<Post>?) -> Unit) {
        RetrofitInstance.apiService.getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) { onResult(null) }
        })
    }

    fun getPostById(id: Int, onResult: (Post?) -> Unit) {
        RetrofitInstance.apiService.getPostById(id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) { onResult(null) }
        })
    }

    fun createPost(post: Post, onResult: (Post?) -> Unit) {
        RetrofitInstance.apiService.createPost(post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) { onResult(null) }
        })
    }

    fun updatePost(id: Int, post: Post, onResult: (Post?) -> Unit) {
        RetrofitInstance.apiService.updatePost(post, id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) { onResult(null) }
        })
    }

    fun deletePostById(id: Int, onResult: (Boolean) -> Unit) {
        RetrofitInstance.apiService.deletePostById(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) { onResult(response.isSuccessful) }
            override fun onFailure(call: Call<Void>, t: Throwable) { onResult(false) }
        })
    }
}