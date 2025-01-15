package pt.iade.ei.iadesocial.models

import java.io.Serializable

data class Users(
    val email: String,
    val id: Int? = null,
    val password: String,
    val studentId: Int,
    val username: String
): Serializable