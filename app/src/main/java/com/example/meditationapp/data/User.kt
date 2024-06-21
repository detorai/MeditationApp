package com.example.meditationapp.data

data class User(
    val id: String,
    val email: String,
    val nickName: String,
    val avatar: String,
    val token: String

)

data class AuthUser(
    val email: String,
    val password: String
)

