package com.example.model

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName(TEXT)
    val text: String,
    @SerializedName(MEANINGS)
    val meanings: List<Meanings> = listOf()
)