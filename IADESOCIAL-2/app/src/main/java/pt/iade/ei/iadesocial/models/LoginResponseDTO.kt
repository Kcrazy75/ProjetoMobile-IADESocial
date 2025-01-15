package pt.iade.ei.iadesocial.models

import java.io.Serializable

data class LoginResponseDTO(
    val userId: Int,
    val token: String
): Serializable
