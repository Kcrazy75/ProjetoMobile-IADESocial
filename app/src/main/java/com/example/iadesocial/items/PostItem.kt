package com.example.iadesocial.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iadesocial.R
import com.example.iadesocial.data.Comment
import com.example.iadesocial.data.Post
import com.example.iadesocial.data.sampleComments
import com.example.iadesocial.data.samplePost
import com.example.iadesocial.data.sampleUsers

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    PostItem(samplePost(), sampleComments())
}

@Composable
fun PostItem(post: Post, comments: List<Comment>) {
    var showFullContent by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableStateOf("Home") }
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        //1st Row
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { selectedTab = "Profile" }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "User Icon"
                )
            }
            Text(
                modifier = Modifier
                    .width(290.dp),
                text = post.username,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 18.sp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { /* More Actions */ })
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
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .fillMaxWidth()
                //.padding(4.dp)
                //.background(Color.White)
            )
        }

        //3rd Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .width(260.dp)
                    .clickable{ showFullContent = !showFullContent },
                text = buildAnnotatedString{
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
                    {append(post.username)}
                    append(" "+post.content)
                },
                maxLines = if (showFullContent) 10 else 1,
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
        //Placeholder for comments
        CommentsSection(comments,isExpanded) {isExpanded = !isExpanded}
        Spacer(modifier = Modifier.height(8.dp))
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun CommentsSection(comments: List<Comment>, isExpanded: Boolean, onToggle: () -> Unit) {
    val user = sampleUsers()

    Column(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            if (comments.isNotEmpty()) {
                if (!isExpanded) {
                    Text(
                        text = "${user[0].username} ${comments[0].content}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black,
                        modifier = Modifier
                            .clipToBounds()
                            .clickable { onToggle() },
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = "View all ${comments.size} comments",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .clickable { onToggle() }
                    )
                } else {
                    comments.forEach {
                        comment -> Text(
                            text = "${user[0].username}: ${comment.content}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                        )
                    }
                    Text(
                        text = "Hide comments",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Blue,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .clickable { onToggle() }
                    )
                }
            }
        }
    }
}