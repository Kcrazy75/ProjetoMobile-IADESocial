package com.example.iadesocial.ui.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.iadesocial.R
import com.example.iadesocial.data.models.entities.Profile
import com.example.iadesocial.data.models.entities.User

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(){
    SignUpView(onSignUp = {})
}

@Composable
fun SignUpView(onSignUp: (User) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var studentID by remember { mutableStateOf("") }

    var email by remember { mutableStateOf("") }
    val bio by remember { mutableStateOf("") }
    val profilePicture by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(value = false) }
    var passwordC by remember { mutableStateOf("") }
    var showPasswordC by remember { mutableStateOf(value = false) }
    val context = LocalContext.current

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
            value = studentID,
            onValueChange = { studentID = it },
            singleLine = true,
            label = { Text(text = "Student ID") },
            placeholder = { Text(text = "Type Student ID Here") },
            shape = RoundedCornerShape(percent = 20),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = name,
            onValueChange = { newText -> name = newText },
            singleLine = true,
            label = { Text(text = "Full Name") },
            placeholder = { Text(text = "Type Name here") },
            shape = RoundedCornerShape(percent = 20),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = username,
            onValueChange = { newText -> username = newText },
            singleLine = true,
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Type Username here") },
            shape = RoundedCornerShape(percent = 20),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = email,
            onValueChange = { newText -> email = newText },
            singleLine = true,
            label = { Text(text = "E-mail") },
            placeholder = { Text(text = "Type E-mail here") },
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
                if(username.isNotEmpty() &&
                    name.isNotEmpty() &&
                    password.isNotEmpty() &&
                    password == passwordC &&
                    email.isNotEmpty()
                ){
                    val user = User(
                        username = username,
                        email = email,
                        password = password,
                        name = name,
                        studentID = studentID.toInt(),
                        profile = Profile(
                            name = name,
                            bio = bio,
                            profilePicture = profilePicture,
                            posts = emptyList(),
                            comments = emptyList(),
                            followers = emptyList(),
                            following = emptyList(),
                        )
                    )
                    onSignUp(user)
                } else {
                    Toast.makeText(context, "Please fill in all fields and ensure passwords match", Toast.LENGTH_SHORT).show()
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