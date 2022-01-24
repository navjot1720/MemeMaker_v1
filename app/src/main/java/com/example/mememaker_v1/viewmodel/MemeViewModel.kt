package com.example.mememaker_v1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mememaker_v1.Meme
import com.example.mememaker_v1.data.DataRepository
import com.example.mememaker_v1.network.NetworkService
import kotlinx.coroutines.launch

class MemeViewModel: ViewModel() {

    private val networkService = NetworkService.getService()
    private val dateRepo = DataRepository(networkService)

    private val _refreshBtnClicked = MutableLiveData<Boolean>(false)
    val refreshBtnClicked: LiveData<Boolean>
        get() = _refreshBtnClicked

    private val _memeList = MutableLiveData<List<Meme>>()
    val memeList : LiveData<List<Meme>>
        get() = _memeList

    init {
        fetchMemes()
    }

    fun fetchMemes() {
        //TODO - Only take memes whose topText is not empty
        _memeList.value = dateRepo.getMemeList()
    }

    fun refreshMemesList() {
        _refreshBtnClicked.value = true
    }

    fun getMeme(id: Int): Meme? {
      return _memeList.value?.toList()?.filter { it.ID == id }?.elementAtOrNull(0)
    }
}