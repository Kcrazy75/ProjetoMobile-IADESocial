package pt.iade.ei.iadesocial.api

import pt.iade.ei.iadesocial.models.LoginRequestDTO
import pt.iade.ei.iadesocial.models.LoginResponseDTO
import pt.iade.ei.iadesocial.models.Users

interface UsersRepository {

    // Obter todos os usuários
    suspend fun getAllUsers(): Result<List<Users>>

    // Obter um usuário pelo ID
    suspend fun getUserById(id: Int): Result<Users>

    // Realizar login de um usuário
    suspend fun login(loginRequestDTO: LoginRequestDTO): Result<LoginResponseDTO>

    // Registrar um novo usuário
    suspend fun register(users: Users): Result<Users>
}
