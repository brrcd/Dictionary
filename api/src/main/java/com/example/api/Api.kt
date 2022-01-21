package com.example.api

import com.example.model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("words/search")
    fun search(@Query("search") wordsToSearch: String): Call<List<DataModel>>
}