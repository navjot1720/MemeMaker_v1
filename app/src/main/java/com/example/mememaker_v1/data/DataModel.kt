package com.example.mememaker_v1

data class MemeResponse(
    val code: Int,
    val `data`: List<Meme>,
    val message: String,
    val next: String
)

data class Meme(
    val ID: Int,
    val bottomText: String,
    val image: String,
    val name: String,
    val tags: String,
    val topText: String? = ""
)