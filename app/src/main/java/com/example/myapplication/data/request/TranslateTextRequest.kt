package com.example.myapplication.data.request

import com.google.gson.annotations.SerializedName

data class TranslateTextRequest(
    @SerializedName("html")
    val text: String,

    @SerializedName("from")
    val from: String = "es",

    @SerializedName("to")
    val to: String = "ru",
)