package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistoryEntity::class], version = 2, exportSchema = false)
abstract class HistoryDatabase: RoomDatabase() {

    abstract fun historyDao(): HistoryDao
}