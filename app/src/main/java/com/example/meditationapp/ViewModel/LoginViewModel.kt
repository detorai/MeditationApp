package com.example.meditationapp.ViewModel

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.meditationapp.R
import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.data.User
import com.example.meditationapp.repository.MainRepository
import kotlinx.coroutines.launch


class LoginViewModel(val mainRepository: MainRepository): ViewModel() {

    val userData = MutableLiveData<User>()

    fun authorize(email: String, password: String) {
        viewModelScope.launch {
            val response = mainRepository.auth(AuthUser(email, password))
            when (response) {
                is ResponseWrapper.Success -> {

                }

                is ResponseWrapper.Error -> {

                }
            }
        }
    }
}
