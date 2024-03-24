package com.example.meditationapp.data


data class ResponseQuotes(
    val success: Boolean,
    val data: List<Quotes>
)


data class Quotes(
    val id:Int,
    val title:String,
    val image:String,
    val description:String
)
