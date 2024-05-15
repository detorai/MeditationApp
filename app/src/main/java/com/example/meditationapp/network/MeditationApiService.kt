package com.example.meditationapp.network

import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseFeeling
import com.example.meditationapp.data.ResponseQuotes
import com.example.meditationapp.data.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface MeditationApiService {
    @POST("user/login")
    suspend fun auth(@Body auth: AuthUser): User

    @GET("feelings")
    suspend fun getFeelings() : ResponseFeeling

    @GET("quotes")
    suspend fun getQuotes() : ResponseQuotes
}
