package com.example.meditationapp.ViewModel


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.data.User
import com.example.meditationapp.repository.MedApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class LoginViewModel(application: Application): AndroidViewModel(application) {

    private val repository by lazy {(application as MedApplication).repository}

    private val _userData = MutableStateFlow<User?>(null)
    val userData: StateFlow<User?> = _userData.asStateFlow()

    fun authorize(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.auth(AuthUser(email, password))

            response.collect{
                when(it){
                    is ResponseWrapper.Success -> {
                        val user = it.data
                        _userData.value = user
                        Log.d("User", "Prishel")
                    }
                    is ResponseWrapper.Error ->{
                        Log.e("User", "Error${it}")
                    }
                }
            }
        }
    }
}
