package com.bm.Droid.repositories

import com.bm.Droid.Database
import com.bm.Droid.models.Question
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class QuestionsRepository(
    private val database: Database,
    private val defaultDispatcher: CoroutineDispatcher,
) {
    suspend fun getAllQuestions(): List<Question> = withContext(defaultDispatcher) {
        val result = database.questionsQueries.selectAll()
            .executeAsList()
            .map {
                Question(
                    id = it._id,
                    level = it.level,
                    questionText = it.questionText,
                    variant1 = it.variant1,
                    variant2 = it.variant2,
                    variant3 = it.variant3,
                    variant4 = it.variant4,
                    answer = it.answer,
                    bibleText = it.bibleText
                )
            }

        return@withContext result
    }
}