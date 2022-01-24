package com.example.mememaker_v1

data class MemeResponse(
    val count: Int,
    val memes: List<Meme>
)

data class Meme(
    val author: String,
    val nsfw: Boolean,
    val postLink: String,
    val preview: List<String>,
    val spoiler: Boolean,
    val subreddit: String,
    val title: String,
    val ups: Int,
    val url: String
)

fun getDummyMeme() = Meme(
    "author",
    false,
    "postlink",
    mutableListOf("https://preview.redd.it/cd0u0vpaxjd81.jpg?width=216\\u0026crop=smart\\u0026auto=webp\\u0026s=5e8ac547982ecfe1af9969c5e9fcf14afd26cebc"),
false,
    "subredit",
"title",
100,
"https://i.redd.it/cd0u0vpaxjd81.jpg")

fun getDummyMemeList() = mutableListOf<Meme>(getDummyMeme(), getDummyMeme(), getDummyMeme(), getDummyMeme())