package com.example.iadesocial.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.iadesocial.R
import pt.iade.ei.iadesocial.models.Comments
import pt.iade.ei.iadesocial.models.Users


@Composable
fun CommentItem(user: Users, comment: Comments) {
    Row(
        modifier = Modifier
            .height(40.dp),
            //.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_iade),
            contentDescription = "User Image",
            modifier = Modifier
                //.border(1.dp, Color.Black, CircleShape)
                .padding(4.dp)
                .clip(CircleShape)
                .size(20.dp)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "${user.username} ${comment.content}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier
                    .padding(4.dp)
                    .width(300.dp)
                    .clipToBounds(),
                //.clickable { onToggle() },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            IconButton(onClick = { /* Like Comment Action */ })
            {
                Icon(
                    imageVector = Icons.Outlined.ThumbUp,
                    contentDescription = "Like Icon",
                    Modifier.size(20.dp),
                    tint = Color.Black
                )
            }
        }
    }
}