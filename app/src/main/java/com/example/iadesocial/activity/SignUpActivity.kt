package com.example.iadesocial.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.iadesocial.MainFeed
import com.example.iadesocial.data.models.UserViewModel
import com.example.iadesocial.data.models.views.SignUpView

class SignUpActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color(0xFFFAFAFA)) {
                SignUpView(
                    onSignUpClick = { user ->
                        userViewModel.signUpUser(user) { response ->
                            if (response?.isSuccessful == true) {
                                Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainFeed::class.java)
                                startActivity(intent)
                                finish()
                            } else { Toast.makeText(this, "Sign Up Failed", Toast.LENGTH_SHORT).show() }
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(){
    SignUpView(onSignUpClick = {})
}
