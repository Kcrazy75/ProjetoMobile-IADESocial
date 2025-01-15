package pt.iade.ei.iadesocial.models

import java.io.Serializable

data class Comments(
    val content: String,
    val id: Int,
    val postId: Int,
    val profileId: Int
): Serializable