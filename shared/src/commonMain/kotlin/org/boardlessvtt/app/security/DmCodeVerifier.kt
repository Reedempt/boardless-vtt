package org.boardlessvtt.app.security

import com.ionspin.kotlin.crypto.signature.Signature
import com.ionspin.kotlin.crypto.signature.InvalidSignatureException

object DmCodeVerifier {

    // Chiave pubblica dell'attività firmataria — non segreta, incorporabile nel sorgente
    private const val PUBLIC_KEY_HEX = "6e0c303a4e27ca2e7f822e7e9dafbe1c875ade2fe9aaf9ef7a9cfdba11e0296a"

    private fun hexToUByteArray(hex: String): UByteArray {
        return UByteArray(hex.length / 2) { i ->
            hex.substring(i * 2, i * 2 + 2).toInt(16).toUByte()
        }
    }

    data class DmCodePayload(val businessId: String, val issuedAt: Long)

    /**
     * Verifica un codice DM in formato Crockford Base32.
     * Ritorna il payload decodificato se la firma è valida, null altrimenti.
     */
    fun verify(code: String): DmCodePayload? {
        return try {
            val decoded = CrockfordBase32.decode(code) // UByteArray: payload + 64 byte di firma
            if (decoded.size <= 64) return null

            val payloadBytes = decoded.copyOfRange(0, decoded.size - 64)
            val signatureBytes = decoded.copyOfRange(decoded.size - 64, decoded.size)

            val publicKey = hexToUByteArray(PUBLIC_KEY_HEX)

            Signature.verifyDetached(signatureBytes, payloadBytes, publicKey)

            val payloadString = payloadBytes.toByteArray().decodeToString()
            val parts = payloadString.split("|")
            if (parts.size != 2) return null

            DmCodePayload(businessId = parts[0], issuedAt = parts[1].toLongOrNull() ?: return null)
        } catch (e: InvalidSignatureException) {
            null
        } catch (e: Exception) {
            null
        }
    }
}

private fun UByteArray.toByteArray(): ByteArray = ByteArray(size) { this[it].toByte() }