package com.example.iadesocial.data.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iadesocial.api.RetrofitInstance
import com.example.iadesocial.data.models.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserViewModel : ViewModel() {
    fun loginUser(username: String, password: String, onResult: (Response<User>?) -> Unit) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                RetrofitInstance.apiService.loginUser(username, password).execute() }
            onResult(response)
        }
    }

    fun signUpUser(user: User, onResult: (Response<User>?) -> Unit) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                RetrofitInstance.apiService.signUpUser(user).execute() }
            onResult(response)
        }
    }
}


