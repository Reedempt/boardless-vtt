package org.boardlessvtt.app.util

import kotlin.random.Random

object JoinCodeGenerator {
    private const val ALPHABET = "0123456789ABCDEFGHJKMNPQRSTVWXYZ"
    private const val LENGTH = 6

    fun generate(): String {
        return (1..LENGTH).map { ALPHABET[Random.nextInt(ALPHABET.length)] }.joinToString("")
    }
}
