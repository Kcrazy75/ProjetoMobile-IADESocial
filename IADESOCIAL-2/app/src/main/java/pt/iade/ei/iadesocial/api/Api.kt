package pt.iade.ei.iadesocial.api

import pt.iade.ei.iadesocial.models.Comments
import pt.iade.ei.iadesocial.models.LoginRequestDTO
import pt.iade.ei.iadesocial.models.LoginResponseDTO
import pt.iade.ei.iadesocial.models.Posts
import pt.iade.ei.iadesocial.models.Profiles
import pt.iade.ei.iadesocial.models.Users
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("users")
    suspend fun getUsers(): List<Users>

    @GET("users/{id}")
    suspend fun getUsersById(@Path("id") id: Int): Users

    @POST("users/login")
    suspend fun login(@Body loginRequestDTO: LoginRequestDTO): LoginResponseDTO

    @POST("users/register")
    suspend fun register(@Body users: Users): Users
    // Endpoint para listar todos os perfis
    @GET("profiles")
    suspend fun getProfiles(): List<Profiles>

    // Endpoint para obter um perfil específico por ID
    @GET("profiles/{id}")
    suspend fun getProfile(@Path("id") id: Int): Profiles

    // Endpoint para criar um novo perfil
    @POST("profiles/create")
    suspend fun createProfile(@Body newProfile: Profiles): Profiles

    // Endpoint para atualizar um perfil existente
    @PUT("profiles/{id}/update")
    suspend fun updateProfile(@Path("id") id: Int, @Body updatedProfile: Profiles): Profiles

    // Endpoint para deletar um perfil
    @DELETE("profiles/{id}/delete")
    suspend fun deleteProfile(@Path("id") id: Int)

    // Endpoint para obter o perfil por UserID
    @GET("profiles/user/{userId}")
    suspend fun getProfileByUserId(@Path("userId") userId: Int): Profiles

    // Endpoint para listar todos os posts
    @GET("posts")
    suspend fun getAllPosts(): List<Posts>

    // Endpoint para criar um novo post
    @POST("posts/create")
    suspend fun createPost(@Body newPost: Posts): Posts

    // Endpoint para listar todos os comentários de um post específico
    @GET("comments/post/{postId}")
    suspend fun getCommentsByPostId(@Path("postId") postId: Int): List<Comments>

    // Endpoint para criar um novo comentário
    @POST("comments/create")
    suspend fun createComment(@Body newComment: Comments): Comments

    companion object{

        const val BASE_URL = "http://10.0.2.2:8080/api/"

    }
}