package pt.iade.ei.iadesocial.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pt.iade.ei.iadesocial.api.ProfilesRepository
import pt.iade.ei.iadesocial.models.Profiles
import pt.iade.ei.iadesocial.api.Result

class ProfilesViewModel(private val repository: ProfilesRepository) : ViewModel() {

    private val _profileState = MutableStateFlow<Result<Profiles>?>(null)
    val profileState: StateFlow<Result<Profiles>?> = _profileState

    private val _createProfileState = MutableStateFlow<Result<Profiles>?>(null)
    val createProfileState: StateFlow<Result<Profiles>?> = _createProfileState

    private val _updateProfileState = MutableStateFlow<Result<Profiles>?>(null)
    val updateProfileState: StateFlow<Result<Profiles>?> = _updateProfileState

    private val _deleteProfileState = MutableStateFlow<Result<Unit>?>(null)
    val deleteProfileState: StateFlow<Result<Unit>?> = _deleteProfileState

    // Função para obter um perfil pelo ID
    fun fetchProfile(id: Int) {
        viewModelScope.launch {
            val result = repository.getProfile(id)
            _profileState.value = result
        }
    }

    // Função para criar um novo perfil
    fun createProfile(newProfile: Profiles) {
        viewModelScope.launch {
            val result = repository.createProfile(newProfile)
            _createProfileState.value = result
        }
    }

    // Função para atualizar um perfil existente
    fun updateProfile(id: Int, updatedProfile: Profiles) {
        viewModelScope.launch {
            val result = repository.updateProfile(id, updatedProfile)
            _updateProfileState.value = result
        }
    }

    // Função para deletar um perfil pelo ID
    fun deleteProfile(id: Int) {
        viewModelScope.launch {
            val result = repository.deleteProfile(id)
            _deleteProfileState.value = result
        }
    }

    // Função para obter um perfil pelo UserID
    fun fetchProfileByUserId(userId: Int) {
        viewModelScope.launch {
            val result = repository.getProfileByUserId(userId)
            _profileState.value = result
        }
    }
}
