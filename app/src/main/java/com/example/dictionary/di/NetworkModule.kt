package com.example.dictionary.di

import com.example.dictionary.Api
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

    @Reusable
    @Provides
    fun provideApi(): Api =
        Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru/api/public/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(Api::class.java)
}