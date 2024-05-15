package com.example.meditationapp.repository

import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.network.MeditationApiService

class MainRepository(val meditationApiService: MeditationApiService)  {
    suspend fun auth(authUser: AuthUser) : ResponseWrapper<AuthUser> {
       val result =  meditationApiService.auth(authUser)
        if()
            return ResponseWrapper.Error
            return ResponseWrapper.Success

    }


}
