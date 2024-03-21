package com.example.meditationapp.data


data class ApiResponse(
    val success: Boolean,
    val data: List<Feelings>
)
data class Feelings(
    val id:Int,
    val title:String,
    val position:Int,
    val image:String
)
