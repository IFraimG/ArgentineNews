package com.example.myapplication.data.request

import com.google.gson.annotations.SerializedName

data class TranslateTextRequest(
    @SerializedName("q")
    val text: String,

    @SerializedName("source")
    val from: String = "es",

    @SerializedName("target")
    val to: String = "ru",
)