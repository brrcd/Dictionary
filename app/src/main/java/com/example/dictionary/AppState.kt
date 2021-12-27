package com.example.dictionary

sealed class AppState {
    data class Success(val data: List<DataModel>) : AppState()
    data class Error(val message: String) : AppState()
    object Loading : AppState()
}