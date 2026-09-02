package org.boardlessvtt.app.security

import com.ionspin.kotlin.crypto.LibsodiumInitializer
import com.ionspin.kotlin.crypto.pwhash.PasswordHash
import com.ionspin.kotlin.crypto.pwhash.crypto_pwhash_OPSLIMIT_MODERATE
import com.ionspin.kotlin.crypto.pwhash.crypto_pwhash_MEMLIMIT_MODERATE

object PasswordCrypto {

    suspend fun initialize() {
        LibsodiumInitializer.initialize()
    }

    fun hashPassword(plainPassword: String): String {
        return PasswordHash.str(
            password = plainPassword,
            opslimit = crypto_pwhash_OPSLIMIT_MODERATE,
            memlimit = crypto_pwhash_MEMLIMIT_MODERATE
        )
    }

    fun verifyPassword(plainPassword: String, storedHash: String): Boolean {
        return PasswordHash.strVerify(storedHash, plainPassword)
    }
}