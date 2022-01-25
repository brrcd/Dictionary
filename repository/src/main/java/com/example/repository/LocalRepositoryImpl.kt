package com.example.repository

import com.example.database.HistoryDatabase
import com.example.database.HistoryEntity

class LocalRepositoryImpl(private val database: HistoryDatabase) : LocalRepository {

    override suspend fun getAllWords(): List<com.example.model.DataModel> =
        database.historyDao().getAll().map {
            com.example.model.DataModel(it.word)
        }

    override suspend fun saveWord(word: String) =
        database.historyDao().saveWord(
            HistoryEntity(word)
        )
}

interface LocalRepository {
    suspend fun getAllWords(): List<com.example.model.DataModel>
    suspend fun saveWord(word: String)
}
