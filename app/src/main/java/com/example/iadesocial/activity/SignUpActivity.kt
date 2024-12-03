package com.example.iadesocial.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.iadesocial.api.RetrofitInstance
import com.example.iadesocial.data.models.entities.User
import com.example.iadesocial.ui.views.SignUpView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color(0xFFFAFAFA)) {
                val context = this
                SignUpView(
                    onSignUpClick = { user ->
                        registerUser(user, context)
                    }
                )
            }
        }
    }

    private fun registerUser(user: User, context: Context) {
        val call = RetrofitInstance.apiService.signUpUser(user)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "Registration Successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(context, "Network Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(){
    SignUpView(onSignUpClick = {})
}
