package com.example.myapplication.data.dto

import com.google.gson.annotations.SerializedName

data class NewsListDTO(
    @SerializedName("articles")
    val news: List<NewsDTO>
)