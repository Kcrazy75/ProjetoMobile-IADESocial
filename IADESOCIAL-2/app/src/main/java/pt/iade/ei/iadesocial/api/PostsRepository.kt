package pt.iade.ei.iadesocial.api

import kotlinx.coroutines.flow.Flow
import pt.iade.ei.iadesocial.models.Posts
import pt.iade.ei.iadesocial.api.Result

interface PostsRepository {

    // Obter todos os posts
    suspend fun getAllPosts(): Flow<Result<List<Posts>>>

    // Criar um novo post
    suspend fun createPost(newPost: Posts): Result<Posts>
}
