package com.example.dictionary

import com.example.dictionary.model.DataModel

sealed class AppState {
    data class Success(val data: List<DataModel>) : AppState()
    data class Error(val message: String) : AppState()
    object Loading : AppState()
}