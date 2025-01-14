package com.example.iadesocial.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Block
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Report
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.iadesocial.data.SampleData
import com.example.iadesocial.data.SampleData.followers
import com.example.iadesocial.data.models.entities.Profile

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuScreen(navController = rememberNavController())
        }
    }
}

@Composable
fun MenuItem(icon: ImageVector, text: String, navController: NavController,onClick: () -> Unit = {}) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { navController.navigate(route = text) }
            .padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun MenuScreen(navController: NavController) {
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text( text = "Menu", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        HorizontalDivider(thickness = 1.dp, color = Color.Black)

        MenuItem(icon = Icons.Outlined.Settings, text = "Settings",navController)
        MenuItem(icon = Icons.Outlined.BookmarkBorder, text = "Saved",navController)
        MenuItem(icon = Icons.Outlined.People, text = "People",navController)
        HorizontalDivider(thickness = 1.dp, color = Color.Black)

        MenuItem(icon = Icons.Outlined.Report, text = "Report",navController)
    }
}

@Composable
fun MenuSettings(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text( text = "Settings", fontSize = 24.sp, fontWeight = FontWeight.Bold )
        HorizontalDivider(color = Color.Black, thickness = 1.dp)

        MenuItem(icon = Icons.Outlined.Person, text = "Account",navController)
        MenuItem(icon = Icons.Outlined.Language, text = "Language",navController)
        HorizontalDivider(thickness = 1.dp, color = Color.Black)

        MenuItem(icon = Icons.Outlined.Block, text = "Blocked",navController)
    }
}

@Composable
fun MenuBlocked(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text( text = "Blocked Users", fontSize = 24.sp, fontWeight = FontWeight.Bold )
        HorizontalDivider(color = Color.Black, thickness = 1.dp)


    }
}

@Composable
fun MenuSaved(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text( text = "Saved Posts", fontSize = 24.sp, fontWeight = FontWeight.Bold )
        HorizontalDivider(color = Color.Black, thickness = 1.dp)


    }
}

@Composable
fun MenuAccount(navController: NavController){
    val profiles = SampleData.profiles
    val p: Profile = profiles[1]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text( text = "Account Details", fontSize = 24.sp, fontWeight = FontWeight.Bold )
        HorizontalDivider(color = Color.Black, thickness = 1.dp)

        ProfileIdentifier(p)

        ProfileDescription(
            displayName = p.name,
            description = p.bio,
            followedBy = listOf(followers[0].followerProfile.name, followers[1].followerProfile.name),
            otherCount = p.followers.size - 2
        )
    }
}

@Composable @Preview
fun PreviewMenu(){ MenuScreen(navController = rememberNavController()) }

@Composable @Preview
fun PreviewMenuSettings(){ MenuSettings(navController = rememberNavController()) }

@Composable @Preview
fun PreviewMenuSettingsBlocked(){ MenuBlocked(navController = rememberNavController()) }

@Composable @Preview
fun PreviewMenuSaved(){ MenuSaved(navController = rememberNavController()) }

@Composable @Preview
fun PreviewMenuAccount(){ MenuAccount(navController = rememberNavController()) }