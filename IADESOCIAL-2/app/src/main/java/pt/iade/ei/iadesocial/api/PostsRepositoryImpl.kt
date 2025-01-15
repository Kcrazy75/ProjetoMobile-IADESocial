package pt.iade.ei.iadesocial.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pt.iade.ei.iadesocial.models.Posts
import retrofit2.HttpException
import java.io.IOException
import pt.iade.ei.iadesocial.api.Result

class PostsRepositoryImplementation(private val api: Api) : PostsRepository {

    override suspend fun getAllPosts(): Flow<Result<List<Posts>>> {
        return flow {
            val postsFromApi = try {
                api.getAllPosts()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Erro ao carregar os posts"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Erro ao carregar os posts"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Erro ao carregar os posts"))
                return@flow
            }
            emit(Result.Success(postsFromApi))
        }
    }

    override suspend fun createPost(newPost: Posts): Result<Posts> {
        return try {
            val response = api.createPost(newPost)
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error creating post: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error creating post: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }
}

