package pt.iade.ei.iadesocial.models

import java.io.Serializable

data class Posts(
    val content: String,
    val id: Int? = null,
    val profileId: Int
): Serializable