package com.midterm.english_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.midterm.english_app.data.local.DictionaryDao
import com.midterm.english_app.data.local.converters.LabelConverter
import com.midterm.english_app.data.local.converters.MeaningConverter
import com.midterm.english_app.data.local.converters.SynonymConverter
import com.midterm.english_app.data.local.entity.DictionaryEntity

@TypeConverters(value = [MeaningConverter::class, SynonymConverter::class, LabelConverter::class])
@Database(entities = [DictionaryEntity::class], exportSchema = true, version = 2)
abstract class DictionaryDatabase: RoomDatabase() {
    abstract val dictionaryDao: DictionaryDao
}