package com.example.meditationapp.data

data class User(
    val id: Int,
    val email: String,
    val nickName: String,
    val avatar: String,
    val token: String

)

data class AuthUser(
    val email: String,
    val password: String
)

