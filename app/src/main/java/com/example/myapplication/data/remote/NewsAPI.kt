package com.example.myapplication.data.remote

import com.example.myapplication.BuildConfig
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {
    @GET("top-headlines?country=ar&apiKey=${BuildConfig.apiKey}")
    suspend fun getLastNews(): Response<NewsListDTO>
}