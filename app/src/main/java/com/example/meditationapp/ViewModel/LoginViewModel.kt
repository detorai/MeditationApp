package com.example.meditationapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.repository.MainRepository
import kotlinx.coroutines.launch

class LoginViewModel(val mainRepository: MainRepository): ViewModel() {
    fun authorize(email:String, password:String){
        viewModelScope.launch {
            val response = mainRepository.auth(AuthUser(email, password))
            when(response){
                is ResponseWrapper.Success -> {

                }
                is ResponseWrapper.Error ->{

                }
            }
        }
    }
}