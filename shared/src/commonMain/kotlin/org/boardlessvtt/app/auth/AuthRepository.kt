package org.boardlessvtt.app.auth

import org.boardlessvtt.app.db.auth.AuthDatabase
import org.boardlessvtt.app.security.PasswordCrypto
import org.boardlessvtt.app.util.IdGenerator
import org.boardlessvtt.app.util.currentTimeMillis

class AuthRepository(private val database: AuthDatabase) {

    fun register(username: String, password: String, role: String): Result<Unit> {
        val existing = database.authQueries.selectUserByUsername(username).executeAsOneOrNull()
        if (existing != null) {
            return Result.failure(IllegalStateException("Username già esistente"))
        }
        val hash = PasswordCrypto.hashPassword(password)
        database.authQueries.insertUser(
            id = IdGenerator.newId(),
            username = username,
            passwordHash = hash,
            role = role,
            createdAt = currentTimeMillis(),
            lastLoginAt = null
        )
        return Result.success(Unit)
    }

    fun login(username: String, password: String): Result<String> {
        val user = database.authQueries.selectUserByUsername(username).executeAsOneOrNull()
            ?: return Result.failure(IllegalStateException("Utente non trovato"))

        val valid = PasswordCrypto.verifyPassword(password, user.passwordHash)
        if (!valid) {
            return Result.failure(IllegalStateException("Password errata"))
        }
        database.authQueries.updateLastLogin(currentTimeMillis(), user.id)
        return Result.success(user.id)
    }
}