package com.example.myapplication.data.remote

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class NewsListDTO(
    @SerializedName("articles")
    val news: List<NewsDTO>
)