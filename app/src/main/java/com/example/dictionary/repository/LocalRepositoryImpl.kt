package com.example.dictionary.repository

import com.example.dictionary.db.HistoryDatabase
import com.example.dictionary.db.HistoryEntity
import com.example.dictionary.model.DataModel

class LocalRepositoryImpl(private val database: HistoryDatabase) : LocalRepository {

    override suspend fun getAllWords(): List<DataModel> =
        database.historyDao().getAll().map {
            DataModel(it.word)
        }

    override suspend fun saveWord(word: String) =
        database.historyDao().saveWord(
            HistoryEntity(word)
        )
}

interface LocalRepository {
    suspend fun getAllWords(): List<DataModel>
    suspend fun saveWord(word: String)
}
