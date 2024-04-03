package com.example.testrv

import retrofit2.http.GET

interface MedAPI {
    @GET("feelings")
    suspend fun getFeelings() : ApiResponse
}