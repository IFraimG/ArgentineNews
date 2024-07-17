package com.example.myapplication.data.api

import com.example.myapplication.BuildConfig
import com.example.myapplication.data.dto.NewsListDTO
import com.example.myapplication.domain.Configs
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {

    @GET("top-headlines?country=ar&apiKey=${BuildConfig.apiKey}")
    suspend fun getLastNews(): Response<NewsListDTO>

}