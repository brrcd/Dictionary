package com.example.dictionary.model

import com.example.dictionary.IMAGE_URL
import com.example.dictionary.TRANSLATION
import com.google.gson.annotations.SerializedName

data class Meanings(
    @SerializedName(TRANSLATION)
    val translation: Translation?,
    @SerializedName(IMAGE_URL)
    val imageUrl: String?
)