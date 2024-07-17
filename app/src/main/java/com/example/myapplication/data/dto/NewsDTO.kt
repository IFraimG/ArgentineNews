package com.example.myapplication.data.dto

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class NewsDTO (
    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String?,

    @SerializedName("urlToImage")
    val urlToImage: String?,

    @SerializedName("author")
    val author: String?,

    @SerializedName("content")
    val content: String?,

    val translatedTitle: String?,
    val translatedDescription: String?,
    val translatedContent: String?,
    val translatedAuthor: String?

)