package org.boardlessvtt.app.db

import app.cash.sqldelight.db.SqlDriver
import org.boardlessvtt.app.db.auth.AuthDatabase

expect class DatabaseDriverFactory {
    fun createAuthDriver(): SqlDriver
    fun createCoreDriver(): SqlDriver
}

fun createAuthDatabase(factory: DatabaseDriverFactory): AuthDatabase {
    return AuthDatabase(factory.createAuthDriver())
}

fun createBoardlessDatabase(factory: DatabaseDriverFactory): BoardlessDatabase {
    return BoardlessDatabase(factory.createCoreDriver())
}