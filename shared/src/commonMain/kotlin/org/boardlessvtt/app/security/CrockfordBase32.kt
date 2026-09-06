package org.boardlessvtt.app.security

/**
 * Implementazione di Crockford Base32 (https://www.crockford.com/base32.html).
 * Alfabeto senza caratteri ambigui: esclude I, L, O, U.
 * Il decode è case-insensitive e tollera le sostituzioni comuni (O->0, I/L->1).
 */
object CrockfordBase32 {

    private const val ALPHABET = "0123456789ABCDEFGHJKMNPQRSTVWXYZ"

    fun encode(data: UByteArray): String {
        if (data.isEmpty()) return ""
        val sb = StringBuilder()
        var buffer = 0L
        var bitsInBuffer = 0

        for (byte in data) {
            buffer = (buffer shl 8) or byte.toLong()
            bitsInBuffer += 8
            while (bitsInBuffer >= 5) {
                bitsInBuffer -= 5
                val index = ((buffer shr bitsInBuffer) and 0x1F).toInt()
                sb.append(ALPHABET[index])
            }
        }
        if (bitsInBuffer > 0) {
            val index = ((buffer shl (5 - bitsInBuffer)) and 0x1F).toInt()
            sb.append(ALPHABET[index])
        }
        return sb.toString()
    }

    fun decode(input: String): UByteArray {
        val normalized = input.uppercase()
            .replace("O", "0")
            .replace("I", "1")
            .replace("L", "1")
            .filter { it != '-' } // permette codici scritti con trattini per leggibilità

        var buffer = 0L
        var bitsInBuffer = 0
        val output = ArrayList<UByte>()

        for (char in normalized) {
            val value = ALPHABET.indexOf(char)
            if (value < 0) throw IllegalArgumentException("Carattere non valido nel codice: $char")
            buffer = (buffer shl 5) or value.toLong()
            bitsInBuffer += 5
            if (bitsInBuffer >= 8) {
                bitsInBuffer -= 8
                val byteValue = ((buffer shr bitsInBuffer) and 0xFF).toInt().toUByte()
                output.add(byteValue)
            }
        }
        return output.toUByteArray()
    }
}

