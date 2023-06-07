package com.example.youtubeproject.domain

import com.example.youtubeproject.data.Repository
import com.example.youtubeproject.data.RetrofitInstance
import com.example.youtubeproject.data.model.VideoData

class GetVideosUseCase {

    private val repository = Repository(RetrofitInstance.api)

    suspend fun getVideoData(keyWords: String): VideoData? {
        return repository.getVideosByKeyWords(keyWords)
    }

}