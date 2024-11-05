package com.example.iadesocial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                WelcomeScreen(
                    onLoginClick = {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    },
                    onSignUpClick = {
                        val intent = Intent(this, SignUpActivity::class.java)
                        startActivity(intent)
                    }
                )
                MainFeedActivity()
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun WelcomeScreen(onLoginClick: () -> Unit, onSignUpClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.background(painterResource(R.drawable.ic_background))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_iade),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Welcome to IADE Social",
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onLoginClick,
            colors = ButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black),

            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .height(50.dp)
        ) {
            Text("Login")
        }
        Button(
            onClick = onSignUpClick,
            colors = ButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black),

            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .height(50.dp)
        ) {
            Text("Sign Up")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(onLoginClick = {}, onSignUpClick = {})
}
