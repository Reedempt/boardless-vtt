package org.boardlessvtt.app.network

import kotlinx.serialization.Serializable

// ===== Player → DM =====

@Serializable
sealed class ClientMessage {
    @Serializable
    data class JoinCampaign(val campaignId: String, val userId: String) : ClientMessage()

    @Serializable
    data class GetCharacters(val campaignId: String) : ClientMessage()

    @Serializable
    data class CreateCharacter(
        val campaignId: String,
        val ownerUserId: String,
        val raceId: String,
        val classId: String,
        val backgroundId: String,
        val name: String,
        val str: Int,
        val dex: Int,
        val con: Int,
        val intelligence: Int,
        val wis: Int,
        val cha: Int,
        val backgroundAbilityChoices: Map<String, Int>,
        val hitDie: Int
    ) : ClientMessage()

    @Serializable
    data class UpdateHp(val characterId: String, val newHp: Int) : ClientMessage()
}

// ===== DM → Player =====

@Serializable
sealed class ServerMessage {
    @Serializable
    data class JoinAccepted(val campaignId: String) : ServerMessage()

    @Serializable
    data class JoinRejected(val reason: String) : ServerMessage()

    @Serializable
    data class CharactersList(val characters: List<NetworkCharacter>) : ServerMessage()

    @Serializable
    data class CharacterCreated(val character: NetworkCharacter) : ServerMessage()

    @Serializable
    data class Error(val message: String) : ServerMessage()
}

@Serializable
data class NetworkCharacter(
    val id: String,
    val campaignId: String,
    val ownerUserId: String,
    val raceId: String,
    val backgroundId: String,
    val name: String,
    val level: Int,
    val hpCurrent: Int,
    val hpMax: Int,
    val str: Int,
    val dex: Int,
    val con: Int,
    val intelligence: Int,
    val wis: Int,
    val cha: Int,
    val pendingDmApproval: Boolean
)