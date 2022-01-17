package com.example.dictionary.repository

import com.example.dictionary.api.ApiUtils
import com.example.dictionary.model.DataModel
import retrofit2.Response

class RemoteRepositoryImpl : RemoteRepository {
    override fun searchWord(word: String): Response<List<DataModel>> =
        ApiUtils.getRetrofit().search(word).execute()
}

interface RemoteRepository {
    fun searchWord(word: String): Response<List<DataModel>>
}