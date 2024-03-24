package com.example.meditationapp.repository

import com.example.meditationapp.data.ApiResponse
import com.example.meditationapp.data.Feelings
import com.example.meditationapp.data.ResponseQuotes
import retrofit2.Call
import retrofit2.http.GET


interface MeditationApi {
    @GET("feelings")
    suspend fun getFeelings() : ApiResponse

    @GET("quotes")
    suspend fun getQuotes() : ResponseQuotes
}
