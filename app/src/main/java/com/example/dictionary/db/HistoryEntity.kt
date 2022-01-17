package com.example.dictionary.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionary.WORD

@Entity
data class HistoryEntity(
    @PrimaryKey
    @ColumnInfo(name = WORD)
    val word: String
)