package com.bm.Droid

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import java.io.FileOutputStream
import java.io.InputStream

actual class DbDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        val database = context.getDatabasePath("millionaire.db")
        if (!database.exists()) {
            val inputStream = context.resources.openRawResource(R.raw.millionaire)
            val outputStream = FileOutputStream(database.absolutePath)

            inputStream.use { input: InputStream ->
                outputStream.use { output: FileOutputStream ->
                    input.copyTo(output)
                }
            }
        }

        return AndroidSqliteDriver(Database.Schema, context, "millionaire.db")
    }
}