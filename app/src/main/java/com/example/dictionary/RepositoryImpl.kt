package com.example.dictionary

import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RepositoryImpl
@Inject constructor(
    private val api: Api
) : Repository {
    override fun searchWord(word: String): List<DataModel>? =
        api.search(word).execute().body()
}

interface Repository {
    fun searchWord(word: String): List<DataModel>?
}