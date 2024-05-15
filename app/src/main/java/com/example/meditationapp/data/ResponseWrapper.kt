package com.example.meditationapp.data

sealed class  ResponseWrapper<T>(var data: T? = null, var exception: Exception? = null){
    data class Success<T>(val result: T?) : ResponseWrapper<T>(data=result, null)
    data class Error<T>(val except: Exception) : ResponseWrapper<T>(null, except)
}