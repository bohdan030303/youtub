package com.example.youtubeproject.data

import com.example.youtubeproject.data.model.VideoData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface YoutubeApi {
    companion object {
        private const val API_KEY = "AIzaSyDrDVF4j5_J79nXoXIUA9TVYCEkQA5yPmI"
    }


    @Headers("Content-Type: application/json")
    @GET("?part=snippet&maxResults=25&key=$API_KEY")
    suspend fun getVideosByKeyWords(@Query("q") keyWords: String): VideoData
}