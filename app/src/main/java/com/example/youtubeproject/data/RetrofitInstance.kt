package com.example.youtubeproject.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client = OkHttpClient.Builder().build()

    private var gson = GsonBuilder()
        .setLenient()
        .create()

    val api: YoutubeApi = Retrofit.Builder()
        .baseUrl("https://youtube.googleapis.com/youtube/v3/search/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()
        .create(YoutubeApi::class.java)
}