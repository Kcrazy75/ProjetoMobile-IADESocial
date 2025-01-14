package com.example.iadesocial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.iadesocial.activity.LoginActivity
import com.example.iadesocial.activity.SignUpActivity
import com.example.iadesocial.ui.views.WelcomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface{
                WelcomeView(
                    //onLogin = { startActivity(Intent(this, LoginActivity::class.java)) },     //comentar quando tiver a testar
                    onLogin = { startActivity(Intent(this, MainFeed::class.java)) },
                    onSignUp = { startActivity(Intent(this, SignUpActivity::class.java)) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){ WelcomeView(onLogin = {}, onSignUp = {}) }

