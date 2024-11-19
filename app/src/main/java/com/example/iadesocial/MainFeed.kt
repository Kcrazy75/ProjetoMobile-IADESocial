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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.iadesocial.activity.ProfileScreen
import com.example.iadesocial.data.Post
import com.example.iadesocial.data.sampleComments
import com.example.iadesocial.data.samplePosts
import com.example.iadesocial.items.PostItem

class MainFeed : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainFeedScreen() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFeedScreen(posts: List<Post> = samplePosts()) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var selectedTab by remember { mutableStateOf("Home") }

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
                    if (selectedTab == "Home") {
                        IconButton(onClick = { /* Handle menu action */ }) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "Menu"
                            )
                        }
                        } else {
                        IconButton(onClick = { selectedTab = "Home"/* change View */ }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
                actions = {
                    if (selectedTab == "Home") {
                        IconButton(onClick = { /* Handle search action */ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search",
                                tint = Color.Black
                            )
                        }
                    } else {
                        IconButton(onClick = { /* Handle search action */ }) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
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

                IconButton(onClick = { selectedTab = "Home" }) {
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
                    onClick = { /* selectedTab.value = "Create Post" */ },
                ) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = "Create Post",
                        Modifier.size(30.dp),
                        tint = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.width(65.dp))

                IconButton(onClick = { selectedTab = "Profile" }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "profile",
                        Modifier.size(30.dp)
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            when (selectedTab) {
                "Home" -> HomeScreen(posts)
                //"Create Post" -> CreatePostScreen(modifier = Modifier.padding(innerPadding))
                "Profile" -> ProfileScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(posts: List<Post>) {
    LazyColumn(
        state = rememberLazyListState(),
        userScrollEnabled = true,
        modifier = Modifier
            .fillMaxWidth()
    ) {items(posts) {posts -> PostItem(posts,sampleComments()) } }
}

@Preview(showBackground = true)
@Composable
fun MainFeedPreview() {
    MainFeedScreen(samplePosts())
}