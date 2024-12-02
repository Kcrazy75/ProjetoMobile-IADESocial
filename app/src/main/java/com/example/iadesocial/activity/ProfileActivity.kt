package com.example.iadesocial.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.iadesocial.data.models.entities.Post
import com.example.iadesocial.data.models.entities.Profile
import com.example.iadesocial.data.SampleData
import com.example.iadesocial.data.SampleData.followers

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
    val profiles = SampleData.profiles
    val p: Profile = profiles[0]

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(6.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_iade),    //p.image
                contentDescription = null,
                modifier = Modifier
                    .border(1.dp, Color.Black, CircleShape)
                    .padding(3.dp)
                    .clip(CircleShape)
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.weight(7f)
            ) {
                //Profile Stats, need to be coded in
                ProfileStat(numberText = p.posts.size.toString(), text = "Posts")
                ProfileStat(numberText = p.followers.size.toString(), text = "Followers")
                ProfileStat(numberText = p.following.size.toString(), text = "Following")
            }
        }
        Spacer(modifier = Modifier.width(10.dp))

        //Just an Example!! Needs to be an Object
        ProfileDescription(
            displayName = p.name,
            description = p.bio,
            followedBy = listOf(followers[0].followerProfile.name,followers[1].followerProfile.name),
            otherCount = p.followers.size - 2
        )
        Spacer(modifier = Modifier.height(8.dp))
        PostSection(p.posts)
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
                painter = painterResource(id = R.drawable.postex_1),   //post[it].content
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
                painter = painterResource(id = R.drawable.postex_2),   //post[it].content
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
                painter = painterResource(id = R.drawable.postex_4),   //post[it].content
                contentDescription ="post",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp,color = Color.White)
                    //.padding(1.dp)
                    .clickable { /* Change to Post View */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}

@Composable
fun ProfileStat( numberText: String, text: String){
    Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
    ) {
       Text(
           text = numberText,
           fontWeight = FontWeight.Bold,
           fontSize = 20.sp,
       )
        Text( text = text )
    }
}

@Composable
fun ProfileDescription( displayName: String, description: String, followedBy: List<String>, otherCount: Int){
    //val letterSpacing = 0.5.sp
    //val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)

    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            lineHeight = 20.sp
        )
        Text(
            text = description,
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.height(6.dp))
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
                //letterSpacing = 0.5.sp,
                //lineHeight = 20.sp

            )
        }
    }
}