package com.example.meditationapp.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val interceptor = HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    val retrofit = Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/").client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    val service = retrofit.create(MeditationApi::class.java)
 }

