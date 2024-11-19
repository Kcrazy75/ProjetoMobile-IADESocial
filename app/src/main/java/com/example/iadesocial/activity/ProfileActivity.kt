package com.example.iadesocial.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iadesocial.R
import com.example.iadesocial.data.Post
import com.example.iadesocial.data.samplePosts

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen(){
    //var selectedTab by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier
        .fillMaxSize()
        .scrollable(
            orientation = Orientation.Vertical,
            state = rememberScrollState(),
            enabled = true
            )
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_iade),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .border(1.dp, Color.Black, CircleShape)
                    .padding(3.dp)
                    .clip(CircleShape)
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .weight(7f)
            ) {
                //Profile Stats, need to be coded in
                ProfileStat(numberText = "3", text = "Posts")
                ProfileStat(numberText = "5", text = "Followers")
                ProfileStat(numberText = "6", text = "Following")
            }
        }
        Spacer(modifier = Modifier.width(10.dp))

        //Just an Example!! Needs to be an Object
        ProfileDescription(
            displayName = "Kelvin Lamas",
            description = "2 years of coding experience \n" +
                    "Want me to break your app. Just email me!",
            //url = "https://www.youtube.com/codingbeast",
            followedBy = listOf("Aricarlo","E. Peixoto"),
            otherCount = 3
        )

        Spacer(modifier = Modifier.height(10.dp))
        PostSection(samplePosts())
    }
}

@Composable
fun PostSection(post: List<Post>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .scale(1.01f)

    ){
        items(post.size){
            Image(
                painter = painterResource(id = R.drawable.ic_background),
                contentDescription ="post",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp,color = Color.White)
                    //.padding(1.dp)
                    .clickable { /* Change to Post View */ }
            )
        }
        items(post.size){
            Image(
                painter = painterResource(id = R.drawable.ic_background),
                contentDescription ="post",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp,color = Color.White)
                    //.padding(1.dp)
                    .clickable { /* add navigation */ }
            )
        }
        items(post.size){
            Image(
                painter = painterResource(id = R.drawable.ic_background),
                contentDescription ="post",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp,color = Color.White)
                    //.padding(1.dp)
                    .clickable { /* add navigation */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    //ProfileSection()
    ProfileScreen()
    //ProfileScreen(sampleProfile(), innerPadding = PaddingValues())
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
        )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    //url: String,
    followedBy: List<String>,
    otherCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            fontSize = 16.sp,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "",
            fontSize = 16.sp,
            color = Color(0xFF4D61CF),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if(followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed By ")
                    followedBy.forEachIndexed{index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size -1){
                            append(", ")
                        }
                    }
                    if (otherCount>2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight

            )
        }
    }
}