package com.example.iadesocial.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iadesocial.data.SampleData
import com.example.iadesocial.data.models.entities.Profile

class ProfileViewModel: ViewModel() {
    private val profileList = MutableLiveData<List<Profile>>()
    val profile: LiveData<List<Profile>> get() = profileList

    fun loadSampleData() { profileList.value = SampleData.profiles }
}