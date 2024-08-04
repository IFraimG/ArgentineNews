package com.example.myapplication.data.api

import com.example.myapplication.BuildConfig
import com.example.myapplication.data.dto.TranslateNewsDTO
import com.example.myapplication.data.request.TranslateTextRequest
import com.example.myapplication.domain.Configs
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TranslateAPI {

    // "x-rapidapi-host: ${Configs.RAPID_URL}",
    // "x-rapidapi-key: ${BuildConfig.rapidKey}"
    @Headers("Content-Type: application/json")
    @POST("translate")
    suspend fun translateNews(@Body translateNews: TranslateTextRequest): Response<TranslateNewsDTO>
}