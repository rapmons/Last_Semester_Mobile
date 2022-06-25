package com.midterm.english_app.util

import com.midterm.english_app.domain.model.WordModel

class TrieNode<Key>(var key: Key?, var parent: TrieNode<Key>?) {
    val children: HashMap<Key, TrieNode<Key>> = HashMap()
    var isValidWord = false
    var wordModel: WordModel? = null
}
