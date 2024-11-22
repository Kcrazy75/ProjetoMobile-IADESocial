package com.example.iadesocial.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.iadesocial.MainFeed
import com.example.iadesocial.R

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color(0xFFFAFAFA)) {
                SignUpScreen(
                    onSignUpClick = {
                        Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainFeed::class.java)
                        startActivity(intent)
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun SignUpScreen(onSignUpClick: () -> Unit) {
    var userID by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(value = false) }

    var passwordC by remember { mutableStateOf("") }
    var showPasswordC by remember { mutableStateOf(value = false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(R.drawable.ic_applogo),
            contentDescription = null,
            modifier = Modifier.size(240.dp)
        )
        //Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = userID,
            onValueChange = { newText -> userID = newText },
            singleLine = true,
            label = { Text(text = "Student ID") },
            placeholder = { Text(text = "Type Student ID here") },
            shape = RoundedCornerShape(percent = 20),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = fullName,
            onValueChange = { newText -> fullName = newText },
            singleLine = true,
            label = { Text(text = "Full Name") },
            placeholder = { Text(text = "Type Full Name here") },
            shape = RoundedCornerShape(percent = 20),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = userName,
            onValueChange = { newText -> userName = newText },
            singleLine = true,
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Type Username here") },
            shape = RoundedCornerShape(percent = 20),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = password,
            onValueChange = { newText -> password = newText },
            singleLine = true,
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Type password here") },
            shape = RoundedCornerShape(percent = 20),
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else { PasswordVisualTransformation() },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "show_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = passwordC,
            onValueChange = { newText -> passwordC = newText },
            singleLine = true,
            label = { Text(text = "Confirm Password") },
            placeholder = { Text(text = "Type password here") },
            shape = RoundedCornerShape(percent = 20),
            visualTransformation = if (showPasswordC) {
                VisualTransformation.None
            } else { PasswordVisualTransformation() },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                if (showPasswordC) {
                    IconButton(onClick = { showPasswordC = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "show_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPasswordC = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                if (password.equals(passwordC)) {
                    if (userID.isNotEmpty() && fullName.isNotEmpty() && userName.isNotEmpty() && password.isNotEmpty()){
                        onSignUpClick(userID,fullName,userName,password,passwordC)
                        TODO("Add message 'Sign Up Successful!' Not yet implemented")
                    }   else {
                        TODO("Add message 'Please fill in all fields!' Not yet implemented")
                    }
                } else {
                    TODO("Add message 'Password and Confirm Password don't match!' Not yet implemented")
                }
            },
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

fun onSignUpClick(userID: String, fullName: String, userName: String, password: String, passwordC: String) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(){
    SignUpScreen(onSignUpClick = {})
}
