package pt.iade.ei.iadesocial.api


import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import pt.iade.ei.iadesocial.models.SessionManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Use nullable var e inicialize com um método específico
    private var sessionManager: SessionManager? = null

    // Método para inicializar o SessionManager
    fun initializeSessionManager(context: Context) {
        if (sessionManager == null) {
            sessionManager = SessionManager(context)
        }
    }

    // Interceptor para adicionar o token JWT nas requisições
    private val authInterceptor = Interceptor { chain ->
        val token = sessionManager?.getToken() // Use safe call para evitar NullPointerException

        val request = chain.request().newBuilder().apply {
            if (!token.isNullOrEmpty()) {
                addHeader("Authorization", "Bearer $token")
            }
        }.build()

        chain.proceed(request)
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)  // Logar as requisições
        .addInterceptor(authInterceptor)  // Adicionar o token nas requisições
        .build()

    val api: Api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Api.BASE_URL)
        .client(client)
        .build()
        .create(Api::class.java)
}

