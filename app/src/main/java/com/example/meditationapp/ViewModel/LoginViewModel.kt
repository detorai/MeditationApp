package com.example.meditationapp.ViewModel

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.example.meditationapp.R
import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.data.User
import com.example.meditationapp.repository.MainRepository
import com.example.meditationapp.repository.MedApplication
import kotlinx.coroutines.launch



class LoginViewModel(val mainRepository: MainRepository, val savedStateHandle: SavedStateHandle
): ViewModel() {

    val userData = MutableLiveData<User>()

    fun authorize(email: String, password: String) {
        viewModelScope.launch {
            val response = mainRepository.auth(AuthUser(email, password))
            when (response) {
                is ResponseWrapper.Success<*> -> {
                    val user = response.data as? User
                    user?.let { userData.value = it }
                }

                is ResponseWrapper.Error<*> -> {
                    Log.e("Error", "Response fail")
                }
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val myRepository = (this[APPLICATION_KEY] as MedApplication).repository
                LoginViewModel(
                    mainRepository = myRepository,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }
}
