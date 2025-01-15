package pt.iade.ei.iadesocial

import androidx.compose.runtime.Composable


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.tooling.preview.Preview
import com.example.iadesocial.ui.views.WelcomeView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeView()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeViewPreview() {
    WelcomeView()
}
