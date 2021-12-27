package com.example.dictionary

import io.reactivex.rxjava3.core.Observable

class RepositoryImpl(
) : Repository {
    override fun searchWord(word: String): Observable<List<DataModel>> =
        Observable.fromSingle(
            RetrofitImpl.getService()
                .search(word)
        )
}

interface Repository {
    fun searchWord(word: String): Observable<List<DataModel>>
}