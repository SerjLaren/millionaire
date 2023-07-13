package com.bm.Droid

import app.cash.sqldelight.db.SqlDriver

expect class DbDriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DbDriverFactory): Database {
    val driver = driverFactory.createDriver()
    val database = Database(driver)
    return database
    // Do more work with the database (see below).
}