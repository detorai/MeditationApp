package com.example.meditationapp

import android.app.Application
import com.example.meditationapp.network.RetrofitClient
import com.example.meditationapp.repository.MainRepository

class MeditationApplication: Application() {
    val mainRepository:MainRepository
        get() = MainRepository(RetrofitClient.service)
}