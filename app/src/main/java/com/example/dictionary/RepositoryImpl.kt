package com.example.dictionary

import com.example.dictionary.model.DataModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryImpl(
) : Repository {
    override fun searchWord(word: String): Observable<List<DataModel>> =
        RetrofitImpl.getService()
            .search(word)
}

interface Repository {
    fun searchWord(word: String): Observable<List<DataModel>>
}