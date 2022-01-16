package com.example.dictionary

import com.example.dictionary.api.ApiUtils
import com.example.dictionary.model.DataModel
import retrofit2.Response

class RepositoryImpl : Repository {
    override fun searchWord(word: String): Response<List<DataModel>> =
        ApiUtils.getRetrofit().search(word).execute()
}

interface Repository {
    fun searchWord(word: String): Response<List<DataModel>>
}