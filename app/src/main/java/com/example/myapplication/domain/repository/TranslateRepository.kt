package com.example.myapplication.domain.repository

import com.example.myapplication.data.RetrofitInit
import com.example.myapplication.data.dto.TranslateNewsDTO
import com.example.myapplication.data.request.TranslateTextRequest
import retrofit2.Response

class TranslateRepository {
    suspend fun translateNews(text: String): Response<TranslateNewsDTO> = RetrofitInit.translateAPI.translateNews(
        TranslateTextRequest(text = text))
}