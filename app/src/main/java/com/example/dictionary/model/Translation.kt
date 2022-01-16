package com.example.dictionary.model

import com.example.dictionary.TEXT
import com.google.gson.annotations.SerializedName

data class Translation(
    @SerializedName(TEXT)
    val translation: String?
)