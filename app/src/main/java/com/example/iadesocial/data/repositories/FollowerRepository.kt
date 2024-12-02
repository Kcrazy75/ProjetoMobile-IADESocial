package com.example.iadesocial.data.repositories

import com.example.iadesocial.data.models.entities.Follower
import com.example.iadesocial.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerRepository {
    fun getFollowers(onResult: (List<Follower>?) -> Unit) {
        RetrofitInstance.apiService.getAllFollowers().enqueue(object : Callback<List<Follower>> {
            override fun onResponse(
                call: Call<List<Follower>>,
                response: Response<List<Follower>>
            ) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else { onResult(null) }
            }
            override fun onFailure(call: Call<List<Follower>>, t: Throwable) { onResult(null) }
        })
    }

    fun getFollowerById(id: Int, onResult: (Follower?) -> Unit) {
        RetrofitInstance.apiService.getFollowerById(id).enqueue(object : Callback<Follower> {
            override fun onResponse(call: Call<Follower>, response: Response<Follower>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else { onResult(null) }
            }
            override fun onFailure(call: Call<Follower>, t: Throwable) { onResult(null) }
        })
    }

    fun createFollower(follower: Follower, onResult: (Follower?) -> Unit) {
        RetrofitInstance.apiService.createFollower(follower).enqueue(object : Callback<Follower> {
            override fun onResponse(call: Call<Follower>, response: Response<Follower>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else { onResult(null) }
            }
            override fun onFailure(call: Call<Follower>, t: Throwable) { onResult(null) }
        })
    }

    fun updateFollower(id: Int, follower: Follower, onResult: (Follower?) -> Unit) {
        RetrofitInstance.apiService.updateFollower(follower, id).enqueue(object : Callback<Follower> {
            override fun onResponse(call: Call<Follower>, response: Response<Follower>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else { onResult(null) }
            }
            override fun onFailure(call: Call<Follower>, t: Throwable) { onResult(null) }
        })
    }

    fun deleteFollowerById(id: Int, onResult: (Void?) -> Unit) {
        RetrofitInstance.apiService.deleteFollowerById(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else { onResult(null) }
            }
            override fun onFailure(call: Call<Void>, t: Throwable) { onResult(null) }
        })
    }
}