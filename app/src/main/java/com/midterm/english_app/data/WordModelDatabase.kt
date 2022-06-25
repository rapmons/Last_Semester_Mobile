package com.midterm.english_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.midterm.english_app.data.local.WordModelDao
import com.midterm.english_app.data.local.converters.LabelConverter
import com.midterm.english_app.data.local.converters.MeaningConverter
import com.midterm.english_app.data.local.converters.SynonymConverter
import com.midterm.english_app.data.local.entity.BookmarkEntity
import com.midterm.english_app.data.local.entity.HistoryEntity

@TypeConverters(value = [MeaningConverter::class, SynonymConverter::class, LabelConverter::class])
@Database(entities = [BookmarkEntity::class, HistoryEntity::class], exportSchema = true, version = 1)
abstract class WordModelDatabase: RoomDatabase() {
    abstract val wordModelDao: WordModelDao
}