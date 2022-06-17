package com.midterm.english_app.domain.repository

import com.javalon.englishwhiz.data.local.entity.DictionaryEntity
import kotlinx.coroutines.flow.Flow

interface DictionaryBaseRepository {
    fun search(word: String): Flow<List<DictionaryEntity>>

    fun prefixMatch(word: String): Flow<List<DictionaryEntity>>
}