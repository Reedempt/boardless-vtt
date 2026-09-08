package org.boardlessvtt.app.network

import kotlinx.serialization.Serializable

// ===== Player → DM =====

@Serializable
sealed class ClientMessage {
    abstract val requestId: String
    @Serializable
    data class JoinCampaign(override val requestId: String, val joinCode: String, val userId: String) : ClientMessage()

    @Serializable
    data class GetCharacters(override val requestId: String, val campaignId: String) : ClientMessage()

    @Serializable
    data class CreateCharacter(
        override val requestId: String,
        val campaignId: String,
        val ownerUserId: String,
        val raceId: String,
        val classId: String,
        val backgroundId: String,
        val name: String,
        val str: Int, val dex: Int, val con: Int,
        val intelligence: Int, val wis: Int, val cha: Int,
        val backgroundAbilityChoices: Map<String, Int>,
        val hitDie: Int
    ) : ClientMessage()

    @Serializable
    data class UpdateHp(override val requestId: String, val characterId: String, val newHp: Int) : ClientMessage()
}

// ===== DM → Player =====

@Serializable
sealed class ServerMessage {
    abstract val requestId: String?

    @Serializable
    data class JoinAccepted(override val requestId: String?, val campaignId: String) : ServerMessage()

    @Serializable
    data class JoinRejected(override val requestId: String?, val reason: String) : ServerMessage()

    @Serializable
    data class CharactersList(override val requestId: String?, val characters: List<NetworkCharacter>) : ServerMessage()

    @Serializable
    data class CharacterUpdated(override val requestId: String?, val character: NetworkCharacter) : ServerMessage()

    @Serializable
    data class Error(override val requestId: String?, val message: String) : ServerMessage()
}

@Serializable
data class NetworkCharacter(
    val id: String, val campaignId: String, val ownerUserId: String,
    val raceId: String, val backgroundId: String, val name: String, val level: Int,
    val hpCurrent: Int, val hpMax: Int,
    val str: Int, val dex: Int, val con: Int, val intelligence: Int, val wis: Int, val cha: Int,
    val pendingDmApproval: Boolean
)