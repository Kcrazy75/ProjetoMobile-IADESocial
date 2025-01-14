package com.example.iadesocial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iadesocial.activity.MenuAccount
import com.example.iadesocial.activity.MenuBlocked
import com.example.iadesocial.activity.MenuSaved
import com.example.iadesocial.activity.MenuScreen
import com.example.iadesocial.activity.MenuSettings
import com.example.iadesocial.activity.ProfileScreen
import com.example.iadesocial.data.models.entities.Post
import com.example.iadesocial.data.repositories.PostRepository
import com.example.iadesocial.data.SampleData
import com.example.iadesocial.items.PostItem

class MainFeed : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainFeedScreen(navController = rememberNavController()) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFeedScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(50.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFA52A2A),
                    titleContentColor = Color.Black,
                ),
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_applogo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "IADE Social")
                    }
                },
                navigationIcon = {
                    if (navController.currentDestination?.route != "Home") {        //suposto mudar o icone quando nao estiver na home
                        IconButton(onClick = { navController.navigate("Menu")}) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "Menu"
                            )
                        }
                        } else {
                        IconButton(onClick = { navController.popBackStack()}) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
                actions = {
                    if (navController.currentDestination?.route != "Home") {
                        IconButton(onClick = { /* Handle search action */ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search",
                                tint = Color.Black
                            )
                        }
                    }
                },
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFA52A2A),
                contentColor = Color.Black,
                modifier = Modifier
                    .height(50.dp),
            ) {
                Spacer(modifier = Modifier.width(45.dp))

                IconButton(onClick = { navController.navigate("Home") }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        Modifier.size(30.dp)
                    )
                    //Text( text = "Home")
                }

                Spacer(modifier = Modifier.width(65.dp))

                IconButton(
                    modifier = Modifier
                        .size(45.dp),
                    onClick = { /* selectedTab = "CreatePost" */ },
                ) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = "Create Post",
                        Modifier.size(30.dp),
                        tint = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.width(65.dp))

                IconButton(onClick = { navController.navigate("Profile") }){
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "profile",
                        Modifier.size(30.dp)
                    )
                }
            }
        }
    ) { innerPadding -> Box(modifier = Modifier.padding(innerPadding)) {
            //HomeScreen(navController, SampleData.postsForProfile1)
            AppNavHost(navController as NavHostController)
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    //val (posts, setPosts) = remember { mutableStateOf<List<Post>?>(null) }
    //val (loading, setLoading) = remember { mutableStateOf(true) }
    val posts = SampleData.postsForProfile1

    NavHost( navController = navController, startDestination = "home" ) {
        composable("Home") { HomeScreen(navController, posts) }
        //composable("mainfeed") { MainFeedScreen(navController) }
        composable("Profile") { ProfileScreen(navController) }
        composable("Menu") { MenuScreen(navController) }
        composable("Settings") { MenuSettings(navController) }
        composable("Saved") { MenuSaved(navController) }
        composable("Blocked") { MenuBlocked(navController) }
        composable("Account") { MenuAccount(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController, posts: List<Post>) {
    LazyColumn(
        state = rememberLazyListState(),
        userScrollEnabled = true,
        modifier = Modifier
            .fillMaxWidth()
    ) {items(posts) {posts -> PostItem(posts,SampleData.profile1.comments) } }
}

@Preview(showBackground = true)
@Composable
fun MainFeedPreview() {
    MainFeedScreen(navController = rememberNavController())
}