package com.example.iadesocial.data.repositories

import com.example.iadesocial.api.RetrofitInstance
import com.example.iadesocial.data.models.entities.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun getUsers(onResult: (List<User>?) -> Unit) {
        RetrofitInstance.apiService.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) { onResult(null) }
        })
    }

    fun getUserById(id: Int, onResult: (User?) -> Unit) {
        RetrofitInstance.apiService.getUserById(id).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else {  onResult(null) }
            }
            override fun onFailure(call: Call<User>, t: Throwable) { onResult(null) }
        })
    }

    fun createUser(user: User, onResult: (User?) -> Unit) {
        RetrofitInstance.apiService.createUser(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<User>, t: Throwable) { onResult(null) }
        })
    }

    fun updateUser(id: Int, user: User, onResult: (User?) -> Unit) {
        RetrofitInstance.apiService.updateUser(user, id).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<User>, t: Throwable) { onResult(null) }
        })
    }

    fun deleteUserById(id: Int, onResult: (Boolean) -> Unit) {
        RetrofitInstance.apiService.deleteUserById(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) { onResult(response.isSuccessful) }
            override fun onFailure(call: Call<Void>, t: Throwable) { onResult(false) }
        })
    }
}
