package org.boardlessvtt.app.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.boardlessvtt.app.db.auth.AuthDatabase
import org.boardlessvtt.app.rulespack.RulesPackDatabase
import java.io.File

actual class DatabaseDriverFactory {
    private fun openOrCreate(fileName: String, create: (SqlDriver) -> Unit): SqlDriver {
        val dbDir = File(System.getProperty("user.home"), ".boardlessvtt")
        if (!dbDir.exists()) dbDir.mkdirs()
        val dbFile = File(dbDir, fileName)
        val isNew = !dbFile.exists()
        val driver = JdbcSqliteDriver("jdbc:sqlite:${dbFile.absolutePath}")
        if (isNew) create(driver)
        return driver
    }

    actual fun createAuthDriver(): SqlDriver =
        openOrCreate("auth.db") { AuthDatabase.Schema.create(it) }

    actual fun createCoreDriver(): SqlDriver =
        openOrCreate("boardless.db") { BoardlessDatabase.Schema.create(it) }

    actual fun createRulesPackDriver(gameCode: String): SqlDriver =
        openOrCreate("rulespack_$gameCode.db") { RulesPackDatabase.Schema.create(it) }
}