package org.boardlessvtt.app.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.boardlessvtt.app.db.auth.AuthDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createAuthDriver(): SqlDriver {
        return AndroidSqliteDriver(AuthDatabase.Schema, context, "auth.db")
    }
    actual fun createCoreDriver(): SqlDriver {
        return AndroidSqliteDriver(BoardlessDatabase.Schema, context, "boardless.db")
    }
}