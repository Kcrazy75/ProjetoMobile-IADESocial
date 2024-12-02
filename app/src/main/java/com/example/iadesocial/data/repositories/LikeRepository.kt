package com.example.iadesocial.data.repositories

import com.example.iadesocial.data.models.entities.Like
import com.example.iadesocial.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LikeRepository {
    fun getLikes(onResult: (List<Like>?) -> Unit) {
        RetrofitInstance.apiService.getAllLikes().enqueue(object : Callback<List<Like>> {
            override fun onResponse(call: Call<List<Like>>, response: Response<List<Like>>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<List<Like>>, t: Throwable) { onResult(null) }
        })
    }

    fun getLikeById(id: Int, onResult: (Like?) -> Unit) {
        RetrofitInstance.apiService.getLikeById(id).enqueue(object : Callback<Like> {
            override fun onResponse(call: Call<Like>, response: Response<Like>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Like>, t: Throwable) { onResult(null) }
        })
    }

    fun createLike(like: Like, onResult: (Like?) -> Unit) {
        RetrofitInstance.apiService.createLike(like).enqueue(object : Callback<Like> {
            override fun onResponse(call: Call<Like>, response: Response<Like>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Like>, t: Throwable) { onResult(null) }
        })
    }

    fun updateLike(id: Int, like: Like, onResult: (Like?) -> Unit) {
        RetrofitInstance.apiService.updateLike(like, id).enqueue(object : Callback<Like> {
            override fun onResponse(call: Call<Like>, response: Response<Like>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Like>, t: Throwable) { onResult(null) }
        })
    }

    fun deleteLikeById(id: Int, onResult: (Boolean) -> Unit) {
        RetrofitInstance.apiService.deleteLikeById(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) { onResult(response.isSuccessful) }
            override fun onFailure(call: Call<Void>, t: Throwable) { onResult(false) }
        })
    }
}
