package pt.iade.ei.iadesocial.models

import java.io.Serializable

data class Profiles(
    val bio: String,
    val id: Int,
    val name: String,
    val profilePicture: String,
    val userId: Int
): Serializable