package com.example.repository

import com.example.api.ApiUtils
import com.example.model.DataModel
import retrofit2.Response

class RemoteRepositoryImpl : RemoteRepository {
    override fun searchWord(word: String): Response<List<DataModel>> =
        ApiUtils.getRetrofit().search(word).execute()
}

interface RemoteRepository {
    fun searchWord(word: String): Response<List<DataModel>>
}