package com.example.iadesocial.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.iadesocial.MainFeed
import com.example.iadesocial.api.RetrofitInstance
import com.example.iadesocial.data.models.entities.User
import com.example.iadesocial.ui.views.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color(0xFFFAFAFA)) {
                LoginView(
                    onLogin = { username, password -> loginUser(username, password) }
                )
            }
        }
    }

    private fun loginUser(username: String, password: String) {
        val call = RetrofitInstance.apiService.loginUser(username, password)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Log.d("LoginActivity", "Login successful: ${response.body()}")
                    Toast.makeText(this@LoginActivity, "Login Successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity, MainFeed::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Log.d("LoginActivity", "Login failed: ${response.errorBody()}")
                    Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("LoginActivity", "Network error: ${t.message}")
                Toast.makeText(this@LoginActivity, "Network Error: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginView(onLogin = {_,_ -> })
}
