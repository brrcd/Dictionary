package com.example.dictionary

import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("words/search")
    fun search(@Query("search") wordsToSearch: String): Call<List<DataModel>>
}