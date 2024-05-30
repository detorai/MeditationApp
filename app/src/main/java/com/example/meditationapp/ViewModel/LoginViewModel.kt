package com.example.meditationapp.ViewModel

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.runtime.MutableState
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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.meditationapp.MeditationApplication
import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.logging.LoggingEventListener

class LoginViewModel(val mainRepository: MainRepository): ViewModel() {



    private val _authUser = MutableStateFlow(AuthUser(email = "", password = ""))
    val authUser = _authUser.asStateFlow()

    fun setUser(email:String, password:String){
      viewModelScope.launch {
          _authUser.emit(AuthUser(email, password))
      }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = object :ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return LoginViewModel((application as MeditationApplication).mainRepository) as T
            }
        }*/
/*    }*/

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
