package com.example.dictionary

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface MainView: MvpView {
    @SingleState
    fun renderData(appState: AppState)
    @SingleState
    fun onError(error: Throwable)
}