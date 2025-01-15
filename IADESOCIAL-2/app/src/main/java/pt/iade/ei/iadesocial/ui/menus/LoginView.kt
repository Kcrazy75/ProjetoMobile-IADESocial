package com.example.iadesocial.ui.views

import android.content.Intent
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.iadesocial.MainMenuFeedActivity


import pt.iade.ei.iadesocial.R
import pt.iade.ei.iadesocial.models.LoginRequestDTO
import pt.iade.ei.iadesocial.viewmodels.UsersViewModel
import pt.iade.ei.iadesocial.api.Result
import pt.iade.ei.iadesocial.ui.components.TextField

@Composable
fun LoginView(viewModel: UsersViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val loginResponse by viewModel.loginResult.observeAsState()

    var isLoading by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.ic_applogo),
            contentDescription = null,
            modifier = Modifier.size(240.dp)
        )

        //Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Email",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp, start = 3.dp),
                textAlign = TextAlign.Start,
                color = Color.White
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                labelText = "Email",
                leadingIcon = Icons.Default.Person,
                onNext = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Next) }
            )

            Text(
                text = "Password",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp, start = 3.dp),
                textAlign = TextAlign.Start,
                color = Color.White
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                labelText = "Password",
                leadingIcon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation(),
                onNext = { focusManager.clearFocus() }
            )
            Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                isLoading = true
                // Chama a função de login
                val loginRequestDTO = LoginRequestDTO(email, password)
                viewModel.login(loginRequestDTO)
                      },
            colors = ButtonColors(
                containerColor = Color(0xFFA52A2A),
                contentColor = Color.Black,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .height(50.dp)
        ) {
            Text("Login")
        }

    }
    // Observa o estado de login
    when (val result = loginResponse) {
        is Result.Success -> {
            // Se login for bem-sucedido, redireciona
            isLoading = false
            val intent = Intent(context, MainMenuFeedActivity::class.java)
            context.startActivity(intent)
        }
        is Result.Error -> {
            // Exibe a mensagem de erro
            isLoading = false
            Toast.makeText(context, result.message ?: "Login failed", Toast.LENGTH_SHORT).show()
        }
        else -> {
            // Para garantir que o "when" seja exaustivo, você pode adicionar esse ramo else
            // que pode ser usado caso algum estado inesperado aconteça
            isLoading = false
        }
    }
}}