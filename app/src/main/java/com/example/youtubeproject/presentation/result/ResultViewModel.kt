package com.example.youtubeproject.presentation.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubeproject.data.model.VideoData
import com.example.youtubeproject.domain.GetVideosUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel() {

    private val getVideosUseCase = GetVideosUseCase()
    private val _videoDataLiveData = MutableLiveData<VideoData?>()
    val videoDataLiveData: LiveData<VideoData?> get() = _videoDataLiveData

    fun loadVideos(keyWord: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getVideosUseCase.getVideoData(keyWord)
            _videoDataLiveData.postValue(data)
        }
    }

}