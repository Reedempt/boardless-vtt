package org.boardlessvtt.app.db

import app.cash.sqldelight.db.SqlDriver
import org.boardlessvtt.app.db.auth.AuthDatabase

expect class DatabaseDriverFactory {
    fun createAuthDriver(): SqlDriver
}

fun createAuthDatabase(factory: DatabaseDriverFactory): AuthDatabase {
    return AuthDatabase(factory.createAuthDriver())
}