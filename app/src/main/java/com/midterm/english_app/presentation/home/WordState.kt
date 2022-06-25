package com.midterm.english_app.presentation.home

import com.midterm.english_app.domain.model.WordModel

data class WordState(
    val wordModel: WordModel? = null,
    var isLoading: Boolean = false,
    var isContained: Boolean = false
)