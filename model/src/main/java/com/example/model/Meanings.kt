package com.example.model

import com.google.gson.annotations.SerializedName

data class Meanings(
    @SerializedName(TRANSLATION)
    val translation: Translation?,
    @SerializedName(IMAGE_URL)
    val imageUrl: String?
)