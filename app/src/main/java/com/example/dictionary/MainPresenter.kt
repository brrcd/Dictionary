package com.example.dictionary

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class MainPresenter(
    private val repository: Repository
) : MvpPresenter<MainView>() {

    private val disposable = CompositeDisposable()

    fun searchWords(word: String) {
        disposable +=
            repository
                .searchWord(word)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { viewState.renderData(AppState.Loading) }
                .flatMap {
                    if (it.isEmpty()) {
                        Observable.just(AppState.Error("error"))
                    } else {
                        Observable.just(AppState.Success(it))
                    }
                }
                .subscribe(
                    viewState::renderData,
                    viewState::onError
                )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}