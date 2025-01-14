package com.example.iadesocial.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iadesocial.R

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeView(onLogin = {}, onSignUp = {})
}

@Composable
fun WelcomeView(onLogin: () -> Unit, onSignUp: () -> Unit) {

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
            painter = painterResource(R.drawable.ic_iadesociallogo),
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
            onClick = onLogin,
            colors = ButtonColors(
                containerColor = Color(0xFFA52A2A),
                contentColor = Color.Black,
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
            onClick = onSignUp,
            colors = ButtonColors(
                containerColor = Color(0xFFA52A2A),
                contentColor = Color.Black,
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