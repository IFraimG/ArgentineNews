package com.example.myapplication.domain.repository

import com.example.myapplication.data.RetrofitInit
import com.example.myapplication.data.dto.NewsListDTO
import retrofit2.Response

class NewsRepository () {
    suspend fun getLastNews(): Response<NewsListDTO> = RetrofitInit.api.getLastNews()

}