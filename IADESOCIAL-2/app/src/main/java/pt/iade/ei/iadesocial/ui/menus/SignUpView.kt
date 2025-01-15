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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.iadesocial.LoginActivity
import pt.iade.ei.iadesocial.MainMenuFeedActivity
import pt.iade.ei.iadesocial.R
import pt.iade.ei.iadesocial.models.Profiles
import pt.iade.ei.iadesocial.models.Users
import pt.iade.ei.iadesocial.ui.components.TextField
import pt.iade.ei.iadesocial.viewmodels.UsersViewModel
import pt.iade.ei.iadesocial.api.Result



@Composable
fun SignUpView(viewModel: UsersViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var studentID by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val registerResult by viewModel.registerResult.observeAsState()
    LaunchedEffect(registerResult) {
        when (val result = registerResult) {
            is Result.Success -> {
                // Registro bem-sucedido
                Toast.makeText(context, "Registro bem-sucedido!", Toast.LENGTH_SHORT).show()
            }

            is Result.Error -> {
                // Erro no registro
                Toast.makeText(context, "Erro: ${result.message}", Toast.LENGTH_SHORT).show()
            }

            else -> {}
        }
    }
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            TextField(
                value = email,
                onValueChange = { email = it },
                labelText = "Email",
                leadingIcon = Icons.Default.Person,
                onNext = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Next) }
            )

            TextField(
                value = username,
                onValueChange = { username = it },
                labelText = "Username",
                leadingIcon = Icons.Default.Person,
                onNext = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Next) }
            )

            TextField(
                value = studentID,
                onValueChange = { studentID = it },
                labelText = "Student Number",
                leadingIcon = Icons.Default.Person,
                onNext = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Next) }
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

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                // Verifique se os campos necessários estão preenchidos
                if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                    val user = Users(
                        username = username,
                        email = email,
                        password = password,
                       studentId = studentID.toInt(),
                        // Outros campos, se necessário
                    )
                    // Chama o método register no ViewModel
                    viewModel.register(user)
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
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
}