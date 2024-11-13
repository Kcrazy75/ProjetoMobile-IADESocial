package com.example.iadesocial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.iadesocial.data.Post
import com.skydoves.landscapist.glide.GlideImage

class MainFeedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(posts = samplePosts())

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(posts: List<Post>) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFA52A2A),
                    titleContentColor = Color.Black,
                ),
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_applogo),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "IADE Social")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle menu action */ }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle search action */ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
        bottomBar = {
            BottomAppBar(
                //horizontalArrangement = Arrangement.SpaceBetween,
                actions = {

                    IconButton(onClick = { /* switch to main view */ }) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home"
                        )
                    }

                    FloatingActionButton(
                        onClick = { /* Handle add Post action */ },
                        containerColor = Color(0xFFA52A2A),
                        //elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }

                    IconButton(onClick = { /* Handle search action */ }) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Search"
                        )
                    }
                },
            )
        }
    ) { innerPadding -> ScrollContent(samplePosts(),innerPadding) }
}

@Composable
fun ScrollContent(posts: List<Post>, innerPadding: PaddingValues) {
    LazyColumn(
        state = LazyListState(firstVisibleItemIndex = 0),
        userScrollEnabled = true,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {items(posts) {posts -> PostItem(posts)} }
}

/*bottomBar = {
    NavigationBar {
        modifier = Modifier,
        containerColor = Color.White,
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
    }
}
content = {
    LazyColumn(
        state = LazyListState(),
        userScrollEnabled = true,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(posts) { post ->
            PostItem(post)
        }
    }
    )
}*/



//@OptIn(ExperimentalComposeUiApi::class)

@Preview(showBackground = true)
@Composable
fun MainFeedPreview() {
    MainScreen(posts = samplePosts())
}

fun samplePosts(): List<Post> {
    return listOf(
        Post("user001", "Alice", "This is my first post! lets see how long i can make this!", "@drawable/ic_background"),
        Post("user002", "Bob", "Hello everyone!", null),
        Post("user003", "Charlie", "I love programming!", "@drawable/ic_background"),
        Post("user004", "Aricarlo", "Hello everyone!", null)
        //Post("user003", "Charlie", "I love Donuts!", "@drawable/ic_background"),
        //Post("user001", "Alice", "This is my first post!", "@drawable/ic_background"),
        //Post("user002", "Bob", "Hello everyone!", null),
        //Post("user003", "Charlie", "I love programming!", "@drawable/ic_background"),
        //Post("user002", "Bob", "Hello everyone!", null),
        //Post("user003", "Charlie", "I love Donuts!", "@drawable/ic_background"),
        //Post("user001", "Alice", "This is my first post!", "@drawable/ic_background"),
        //Post("user002", "Bob", "Hello everyone!", null),
        //Post("user003", "Charlie", "I love programming!", "@drawable/ic_background"),
        //Post("user002", "Bob", "Hello everyone!", null),
        //Post("user003", "Charlie", "I love Donuts!", "@drawable/ic_background")
    )
}
