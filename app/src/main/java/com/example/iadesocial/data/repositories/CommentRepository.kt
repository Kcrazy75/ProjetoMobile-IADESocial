package com.example.iadesocial.data.repositories

import com.example.iadesocial.data.models.entities.Comment
import com.example.iadesocial.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentRepository {
    fun getComments(onResult: (List<Comment>?) -> Unit) {
        RetrofitInstance.apiService.getAllComments().enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) { onResult(null) }
        })
    }

    fun getCommentById(id: Int, onResult: (Comment?) -> Unit) {
        RetrofitInstance.apiService.getCommentById(id).enqueue(object : Callback<Comment> {
            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Comment>, t: Throwable) { onResult(null) }
        })
    }

    fun createComment(comment: Comment, onResult: (Comment?) -> Unit) {
        RetrofitInstance.apiService.createComment(comment).enqueue(object : Callback<Comment> {
            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Comment>, t: Throwable) { onResult(null) }
        })
    }

    fun updateComment(id: Int, comment: Comment, onResult: (Comment?) -> Unit) {
        RetrofitInstance.apiService.updateComment(comment, id).enqueue(object : Callback<Comment> {
            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Comment>, t: Throwable) { onResult(null) }
        })
    }

    fun deleteCommentById(id: Int, onResult: (Boolean) -> Unit) {
        RetrofitInstance.apiService.deleteCommentById(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) { onResult(response.isSuccessful) }
            override fun onFailure(call: Call<Void>, t: Throwable) { onResult(false) }
        })
    }
}
