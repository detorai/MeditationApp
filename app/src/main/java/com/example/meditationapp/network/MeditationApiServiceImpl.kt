package com.example.meditationapp.network

import com.example.meditationapp.data.AuthUser

class MeditationApiServiceImpl(private val meditationApiService: MeditationApiService) {
    suspend fun auth(authUser: AuthUser) = meditationApiService.auth(authUser)
    suspend fun getFeelings() = meditationApiService.getFeelings()
    suspend fun getQuotes() = meditationApiService.getQuotes()
}