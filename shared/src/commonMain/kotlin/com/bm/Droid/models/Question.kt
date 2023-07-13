package com.bm.Droid.models

data class Question(
    val id: Long,
    val level: Long,
    val questionText: String,
    val variant1: String,
    val variant2: String,
    val variant3: String,
    val variant4: String,
    val answer: Long,
    val bibleText: String?,
)