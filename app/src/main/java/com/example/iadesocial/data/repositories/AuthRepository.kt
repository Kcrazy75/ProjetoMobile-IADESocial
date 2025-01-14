package com.example.iadesocial.data.repositories

import com.example.iadesocial.api.RetrofitInstance
import com.example.iadesocial.data.models.entities.LoginRequest
import com.example.iadesocial.data.models.entities.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    fun login(username: String, password: String, onResult: (LoginResponse?) -> Unit) {
        val loginRequest = LoginRequest(username, password)
        RetrofitInstance.apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) { onResult(null) }
        })
    }
}