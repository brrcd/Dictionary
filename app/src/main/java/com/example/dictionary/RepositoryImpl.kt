package com.example.dictionary

import com.example.dictionary.api.ApiUtils
import com.example.dictionary.model.DataModel

class RepositoryImpl : Repository {
    override fun searchWord(word: String): List<DataModel>? =
        ApiUtils.getRetrofit().search(word).execute().body()
}

interface Repository {
    fun searchWord(word: String): List<DataModel>?
}