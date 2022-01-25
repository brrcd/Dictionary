package com.example.model

import com.google.gson.annotations.SerializedName

data class Translation(
    @SerializedName(TEXT)
    val translation: String?
)