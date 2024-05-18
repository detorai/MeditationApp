package com.example.meditationapp.ViewModel

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(val mainRepository: MainRepository): ViewModel() {


    private val _authUser = MutableStateFlow(AuthUser(email = "", password = ""))
    val authUser = _authUser.asStateFlow()

    fun setUser(email:String, password:String){
      viewModelScope.launch {
          _authUser.emit(AuthUser(email, password))
      }
    }


//    fun authorize(email:String, password:String){
//        viewModelScope.launch {
//            val response = mainRepository.auth(AuthUser(email, password))
//            when(response){
//                is ResponseWrapper.Success -> {
//
//                }
//                is ResponseWrapper.Error ->{
//
//                }
//            }
//        }
//    }
}