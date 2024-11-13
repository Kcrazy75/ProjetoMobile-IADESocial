package com.example.iadesocial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.iadesocial.data.Post

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    val post = Post(
        "user001",
        "Aricarlo",
        "This is my first post! Lets see how long i can make this! Maybe i can make it go all the way to the end",
        "@drawable/ic_background"
    )
    PostItem(post)
}

@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            //.padding(8.dp)
    ) {
        //1st Row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Profile Action */ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "User Icon"
                )
            }
            Text(
                text = post.username,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { /* Like Action */ })
                {
                    //so aparece no perfil, contem a funcao apagar post
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More Post Settings",
                        tint = Color.Black
                    )
                }
            }
        }

        //2nd Row
        if (post.imageUrl != null) {
            Image(
                painter = painterResource(id = R.drawable.ic_background),
                contentDescription = "User Post",
                modifier = Modifier
                    //.padding(8.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )
        }

        //3rd Row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
                //.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                modifier = Modifier
                    //.padding(8.dp)
                    .width(260.dp),
                text = post.content,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { /* Like Action */ })
                {
                    Icon(
                        imageVector = Icons.Outlined.ThumbUp,
                        contentDescription = "Like Icon",
                        tint = Color.Black
                    )
                }
                IconButton(onClick = { /* Save Action */ }) {
                    Icon(
                        imageVector = Icons.Outlined.BookmarkBorder,
                        contentDescription = "Save Icon",
                        tint = Color.Black
                    )
                }
            }
        }

        // Placeholder for comments
        // CommentsSection(post.comments)
        Spacer(modifier = Modifier.height(16.dp))
    }
}
