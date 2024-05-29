package com.example.meditationapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.meditationapp.repository.MainRepository


class LoginViewModel(val mainRepository: MainRepository): ViewModel() {
    lateinit var NavController: NavController
   /* fun authorize(email:String, password:String){
        viewModelScope.launch {
            val response = mainRepository.auth(AuthUser(email, password))
            when(response){
                is ResponseWrapper.Success -> {
                    val NavController = NavController
                    NavController.navigate(R.id.action_loginFragment_to_mainFragment)
                }

                is ResponseWrapper.Error ->{

                }
            }
        }*/
/*    }*/
}