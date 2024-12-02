package com.example.iadesocial.data.repositories

import com.example.iadesocial.api.RetrofitInstance
import com.example.iadesocial.data.models.entities.Profile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileRepository{
    fun getProfiles(onResult: (List<Profile>?) -> Unit) {
        RetrofitInstance.apiService.getAllProfiles().enqueue(object : Callback<List<Profile>> {
            override fun onResponse(call: Call<List<Profile>>, response: Response<List<Profile>>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<List<Profile>>, t: Throwable) { onResult(null) }
        })
    }

    fun getProfileById(id: Int, onResult: (Profile?) -> Unit) {
        RetrofitInstance.apiService.getProfileById(id).enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Profile>, t: Throwable) { onResult(null) }
        })
    }

    fun createProfile(profile: Profile, onResult: (Profile?) -> Unit) {
        RetrofitInstance.apiService.createProfile(profile).enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Profile>, t: Throwable) { onResult(null) }
        })
    }

    fun updateProfile(id: Int, profile: Profile, onResult: (Profile?) -> Unit) {
        RetrofitInstance.apiService.updateProfile(profile, id).enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                if (response.isSuccessful) { onResult(response.body()) }
                else { onResult(null) }
            }
            override fun onFailure(call: Call<Profile>, t: Throwable) { onResult(null) }
        })
    }

    fun deleteProfileById(id: Int, onResult: (Boolean) -> Unit) {
        RetrofitInstance.apiService.deleteProfileById(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) { onResult(response.isSuccessful) }
            override fun onFailure(call: Call<Void>, t: Throwable) { onResult(false) }
        })
    }
}