package com.example.dictionary.model

import com.example.dictionary.MEANINGS
import com.example.dictionary.TEXT
import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName(TEXT)
    val text: String?,
    @SerializedName(MEANINGS)
    val meanings: List<Meanings>?
)