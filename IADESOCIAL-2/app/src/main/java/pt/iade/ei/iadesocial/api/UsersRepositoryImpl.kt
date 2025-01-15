package pt.iade.ei.iadesocial.api

import pt.iade.ei.iadesocial.models.LoginRequestDTO
import pt.iade.ei.iadesocial.models.LoginResponseDTO
import pt.iade.ei.iadesocial.models.Users
import retrofit2.HttpException
import java.io.IOException
import pt.iade.ei.iadesocial.api.Result

class UsersRepositoryImplementation(private val api: Api) : UsersRepository {

    override suspend fun getAllUsers(): Result<List<Users>> {
        return try {
            val response = api.getUsers()
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error fetching users: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error fetching users: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun getUserById(id: Int): Result<Users> {
        return try {
            val response = api.getUsersById(id)
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error fetching user by ID: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error fetching user by ID: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun login(loginRequestDTO: LoginRequestDTO): Result<LoginResponseDTO> {
        return try {
            val response = api.login(loginRequestDTO)
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error logging in: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error logging in: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun register(users: Users): Result<Users> {
        return try {
            val response = api.register(users)
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error registering user: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error registering user: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }
}
