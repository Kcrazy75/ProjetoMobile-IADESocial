package pt.iade.ei.iadesocial.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pt.iade.ei.iadesocial.models.LoginRequestDTO
import pt.iade.ei.iadesocial.models.LoginResponseDTO
import pt.iade.ei.iadesocial.models.Users
import pt.iade.ei.iadesocial.api.UsersRepository
import pt.iade.ei.iadesocial.api.Result
import pt.iade.ei.iadesocial.models.SessionManager

class UsersViewModel(
    private val usersRepository: UsersRepository,
    context: Context // Adicionando contexto para o SessionManager
) : ViewModel() {

    private val sessionManager = SessionManager(context) // Inicializando o SessionManager

    // LiveData para resultados de login
    private val _loginResult = MutableLiveData<Result<LoginResponseDTO>?>()
    val loginResult: LiveData<Result<LoginResponseDTO>?> get() = _loginResult

    // LiveData para resultados de registro
    private val _registerResult = MutableLiveData<Result<Users>>()
    val registerResult: LiveData<Result<Users>> get() = _registerResult

    // LiveData para lista de usuários
    private val _usersList = MutableLiveData<Result<List<Users>>>()
    val usersList: LiveData<Result<List<Users>>> get() = _usersList

    // LiveData para resultado de um único usuário
    private val _userResult = MutableLiveData<Result<Users>>()
    val userResult: LiveData<Result<Users>> get() = _userResult

    // Função para fazer login
    fun login(loginRequestDTO: LoginRequestDTO) {
        viewModelScope.launch {
            val result = usersRepository.login(loginRequestDTO)
            _loginResult.postValue(result) // Atualiza o LiveData com o resultado

            if (result is Result.Success) {
                val loginResponse = result.data
                if (loginResponse != null) {
                    // Salvar token e user_id na sessão
                    sessionManager.saveSession(
                        token = loginResponse.token,
                        userId = loginResponse.userId
                    )
                }
            }
        }
    }

    // Função para registrar usuário
    fun register(users: Users) {
        viewModelScope.launch {
            val result = usersRepository.register(users)
            _registerResult.postValue(result) // Atualiza o LiveData com o resultado
        }
    }

    // Função para pegar a lista de usuários
    fun getUsers() {
        viewModelScope.launch {
            val result = usersRepository.getAllUsers()
            _usersList.postValue(result) // Atualiza o LiveData com o resultado
        }
    }

    // Função para pegar usuário por ID
    fun getUserById(userId: Int) {
        viewModelScope.launch {
            val result = usersRepository.getUserById(userId)
            _userResult.postValue(result) // Atualiza o LiveData com o resultado
        }
    }

    // Função para fazer logout
    fun logout() {
        sessionManager.clearSession()
    }
}
