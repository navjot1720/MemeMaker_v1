package com.example.mememaker_v1.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkService {

    //TODO - Write GET method to get meme list from URL - http://alpha-meme-maker.herokuapp.com/1
    //TODO - Add "page" number in url. default value should be 1

    companion object {
        private const val BASE_URL = "http://alpha-meme-maker.herokuapp.com/"

        fun getService(): NetworkService {
            val client = OkHttpClient.Builder()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }
    }
}