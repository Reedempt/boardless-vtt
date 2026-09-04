package org.boardlessvtt.app.db

import app.cash.sqldelight.db.SqlDriver
import org.boardlessvtt.app.db.auth.AuthDatabase
import org.boardlessvtt.app.rulespack.RulesPackDatabase

expect class DatabaseDriverFactory {
    fun createAuthDriver(): SqlDriver
    fun createCoreDriver(): SqlDriver
    fun createRulesPackDriver(gameCode: String): SqlDriver
}

fun createAuthDatabase(factory: DatabaseDriverFactory): AuthDatabase {
    return AuthDatabase(factory.createAuthDriver())
}

fun createBoardlessDatabase(factory: DatabaseDriverFactory): BoardlessDatabase {
    return BoardlessDatabase(factory.createCoreDriver())
}

fun createRulesPackDatabase(factory: DatabaseDriverFactory, gameCode: String): RulesPackDatabase {
    return RulesPackDatabase(factory.createRulesPackDriver(gameCode))
}