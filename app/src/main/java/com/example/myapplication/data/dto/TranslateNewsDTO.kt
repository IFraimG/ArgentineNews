package com.example.myapplication.data.dto

import com.google.gson.annotations.SerializedName

data class TranslateNewsDTO(
    @SerializedName("trans")
    val translatedText: String
)
