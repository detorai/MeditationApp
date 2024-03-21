package com.example.meditationapp.repository

import com.example.meditationapp.data.Feelings
import retrofit2.Call
import retrofit2.http.GET


interface MeditationApi {
    @GET("feelings")
    fun getFeelings() : Call<List<Feelings>>
}
