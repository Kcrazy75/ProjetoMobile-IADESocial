package pt.iade.ei.iadesocial.api


import pt.iade.ei.iadesocial.models.Profiles
import pt.iade.ei.iadesocial.api.Result

interface ProfilesRepository {

    // Obter um perfil específico por ID
    suspend fun getProfile(id: Int): Result<Profiles>

    // Criar um novo perfil
    suspend fun createProfile(newProfile: Profiles): Result<Profiles>

    // Atualizar um perfil existente
    suspend fun updateProfile(id: Int, updatedProfile: Profiles): Result<Profiles>

    // Deletar um perfil
    suspend fun deleteProfile(id: Int): Result<Unit>

    // Obter o perfil por UserID
    suspend fun getProfileByUserId(userId: Int): Result<Profiles>
}
