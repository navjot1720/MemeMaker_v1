package com.example.mememaker_v1.data

import com.example.mememaker_v1.Meme
import com.example.mememaker_v1.network.NetworkService

class DataRepository(val networkService: NetworkService) {

    suspend fun getMemeList(): List<Meme>  {
        return networkService.getMemes().data
    }
}