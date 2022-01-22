package com.example.mememaker_v1.data

import com.example.mememaker_v1.Meme
import com.example.mememaker_v1.getDummyMemeList
import com.example.mememaker_v1.network.NetworkService

class DataRepository(val networkService: NetworkService) {

    fun getMemeList(): List<Meme>  {

        //TODO - get Meme list from NetworkService
        return getDummyMemeList()
    }
}