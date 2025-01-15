package pt.iade.ei.iadesocial.api


import pt.iade.ei.iadesocial.models.Profiles
import retrofit2.HttpException
import java.io.IOException
import pt.iade.ei.iadesocial.api.Result

class ProfilesRepositoryImplementation(private val api: Api) : ProfilesRepository {

    override suspend fun getProfile(id: Int): Result<Profiles> {
        return try {
            val response = api.getProfile(id)
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error fetching profile: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error fetching profile: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun createProfile(newProfile: Profiles): Result<Profiles> {
        return try {
            val response = api.createProfile(newProfile)
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error creating profile: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error creating profile: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun updateProfile(id: Int, updatedProfile: Profiles): Result<Profiles> {
        return try {
            val response = api.updateProfile(id, updatedProfile)
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error updating profile: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error updating profile: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun deleteProfile(id: Int): Result<Unit> {
        return try {
            api.deleteProfile(id)
            Result.Success(Unit)
        } catch (e: IOException) {
            Result.Error(message = "Error deleting profile: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error deleting profile: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }

    override suspend fun getProfileByUserId(userId: Int): Result<Profiles> {
        return try {
            val response = api.getProfileByUserId(userId)
            Result.Success(response)
        } catch (e: IOException) {
            Result.Error(message = "Error fetching profile by user ID: ${e.message}")
        } catch (e: HttpException) {
            Result.Error(message = "HTTP error fetching profile by user ID: ${e.message()}")
        } catch (e: Exception) {
            Result.Error(message = "Unexpected error: ${e.message}")
        }
    }
}
