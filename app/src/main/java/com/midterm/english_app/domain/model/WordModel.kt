package com.midterm.english_app.domain.model

import com.javalon.englishwhiz.data.local.entity.BookmarkEntity
import com.javalon.englishwhiz.data.local.entity.HistoryEntity
import com.javalon.englishwhiz.data.local.entity.Meaning
import com.midterm.english_app.data.local.entity.Meaning
import com.midterm.english_app.data.local.entity.BookmarkEntity
import com.midterm.english_app.data.local.entity.HistoryEntity

data class WordModel(
    val meanings: List<Meaning>?,
    val word: String,
    val wordsetId: String
) {
    fun toBookmarkEntity(): BookmarkEntity {
        return BookmarkEntity(meanings, word, wordsetId)
    }

    fun toHistoryEntity(): HistoryEntity {
        return HistoryEntity(meanings, word, wordsetId)
    }
}