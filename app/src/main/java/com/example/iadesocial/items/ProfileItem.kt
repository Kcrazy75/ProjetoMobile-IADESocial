package com.example.iadesocial.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.iadesocial.R
import com.example.iadesocial.activity.ProfileDescription
import com.example.iadesocial.activity.ProfileStat
import com.example.iadesocial.data.models.entities.Profile
import com.example.iadesocial.data.SampleData
import com.example.iadesocial.data.SampleData.followers

@Composable
fun ProfileItem() {
    //var selectedTab by remember { mutableIntStateOf(0) }
    val profiles = SampleData.profiles
    val p: Profile = profiles[0]

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(6.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_iade), // Replace with your profile picture
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
            followedBy = listOf(followers[0].followerProfile.name, followers[1].followerProfile.name),
            otherCount = p.followers.size - 2
        )
    }
}