package org.boardlessvtt.app.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.boardlessvtt.app.db.auth.AuthDatabase
import java.io.File

actual class DatabaseDriverFactory {
    actual fun createAuthDriver(): SqlDriver {
        val dbDir = File(System.getProperty("user.home"), ".boardlessvtt")
        if (!dbDir.exists()) dbDir.mkdirs()
        val dbFile = File(dbDir, "auth.db")
        val isNew = !dbFile.exists()
        val driver = JdbcSqliteDriver("jdbc:sqlite:${dbFile.absolutePath}")
        if (isNew) AuthDatabase.Schema.create(driver)
        return driver
    }

    actual fun createCoreDriver(): SqlDriver {
        val dbDir = File(System.getProperty("user.home"), ".boardlessvtt")
        if (!dbDir.exists()) dbDir.mkdirs()
        val dbFile = File(dbDir, "boardless.db")
        val isNew = !dbFile.exists()
        val driver = JdbcSqliteDriver("jdbc:sqlite:${dbFile.absolutePath}")
        if (isNew) BoardlessDatabase.Schema.create(driver)
        return driver
    }
}