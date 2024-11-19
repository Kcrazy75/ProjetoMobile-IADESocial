package com.example.iadesocial.data

data class Profile(
    val profileId: Int,
    val userId: Int,
    val name: String,
    val bio: String,
    val profilePicture: String,
    val posts: List<Post>,
    val followers: List<Profile>,
    val following: List<Profile>
)

/*fun consProfile(profile: Profile): Profile {
    return Profile(
        profileId = ${profile.profileId},
        userId = ${profile.userId},
        name = ${profile.name},
        bio = ${profile.bio},
        profilePicture = ${profile.profilePicture},
        posts = ${profile.posts},
        followers = ${profile.followers},
        following = ${profile.following}
    )
}*/

fun sampleProfile(): Profile {
    return (
        Profile(1,20220296,"Kelvin","This is my Bio","@drawable/ic_iade. png",
            //lista de posts
            samplePosts(),
            //lista de followers
            listOf(
                Profile(2,20220297,"Aricarlo","This is My Bio","@drawable/ic_iade. png",listOf(),listOf(),listOf()),
                Profile(3,20220298,"Edson","This is My Bio","@drawable/ic_iade. png",listOf(),listOf(),listOf()),
            ),
            //lista de following
            listOf(
                Profile(2,20220297,"Aricarlo","This is My Bio","@drawable/ic_iade. png",listOf(),listOf(),listOf()),
                Profile(3,20220298,"Edson","This is My Bio","@drawable/ic_iade. png",listOf(),listOf(),listOf()),
            ),
        )
    )
}

fun sampleProfiles(): List<Profile> {
    return listOf(
        Profile(1,20220296,"Kelvin Lamas","2 years of coding experience \n Want me to break your app. Just email me!","",listOf(),listOf(),listOf()),
        Profile(2,20220297,"Aricarlo Alberto","2 years of coding experience \n Want me to break your app. Just email me!","",listOf(),listOf(),listOf()),
        Profile(3,20220298,"Edson Peixoto","2 years of coding experience \n Want me to break your app. Just email me!","",listOf(),listOf(),listOf())
    )
}
