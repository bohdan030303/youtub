package com.example.youtubeproject.data

import com.example.youtubeproject.data.model.VideoData
import java.lang.Exception

class Repository(private val api: YoutubeApi) {

    suspend fun getVideosByKeyWords(keyWords: String): VideoData? {
        try {
            val result = api.getVideosByKeyWords(keyWords)
            return result
        } catch (e: Exception) {
            return null
        }
    }

}