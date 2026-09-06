package org.boardlessvtt.app.character

import org.boardlessvtt.app.db.BoardlessDatabase
import org.boardlessvtt.app.util.IdGenerator
import org.boardlessvtt.app.util.currentTimeMillis
import org.boardlessvtt.app.db.player.Player_characters
import org.boardlessvtt.app.db.player.Player_character_classes

data class AbilityScores(
    val str: Int, val dex: Int, val con: Int,
    val intelligence: Int, val wis: Int, val cha: Int
)

data class CharacterInfo(
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
    val isCustomContent: Boolean,
    val pendingDmApproval: Boolean
)

data class CharacterClassInfo(
    val id: String,
    val characterId: String,
    val classId: String,
    val level: Int,
    val isPrimary: Boolean,
    val approvedByDm: Boolean,
    val requestedAt: Long,
    val approvedAt: Long?
)

class CharacterRepository(private val database: BoardlessDatabase) {

    private fun mapCharacter(row: Player_characters): CharacterInfo = CharacterInfo(
        id = row.id,
        campaignId = row.campaign_id,
        ownerUserId = row.owner_user_id,
        raceId = row.race_id,
        backgroundId = row.background_id,
        name = row.name,
        level = row.level.toInt(),
        hpCurrent = row.hp_current.toInt(),
        hpMax = row.hp_max.toInt(),
        str = row.str.toInt(),
        dex = row.dex.toInt(),
        con = row.con.toInt(),
        intelligence = row.intelligence.toInt(),
        wis = row.wis.toInt(),
        cha = row.cha.toInt(),
        isCustomContent = row.is_custom_content == 1L,
        pendingDmApproval = row.pending_dm_approval == 1L
    )

    private fun mapClass(row: Player_character_classes): CharacterClassInfo = CharacterClassInfo(
        id = row.id,
        characterId = row.character_id,
        classId = row.class_id,
        level = row.level.toInt(),
        isPrimary = row.is_primary == 1L,
        approvedByDm = row.approved_by_dm == 1L,
        requestedAt = row.requested_at,
        approvedAt = row.approved_at
    )

    fun validatePointBuy(scores: AbilityScores, costs: Map<Int, Int>, scoreCap: Int): Int? {
        val allScores = listOf(scores.str, scores.dex, scores.con, scores.intelligence, scores.wis, scores.cha)
        if (allScores.any { it > scoreCap || it < (costs.keys.minOrNull() ?: 8) }) return null
        var total = 0
        for (score in allScores) {
            val cost = costs[score] ?: return null
            total += cost
        }
        return total
    }

    fun createCharacterWithPointBuy(
        campaignId: String,
        ownerUserId: String,
        raceId: String,
        primaryClassId: String,
        backgroundId: String,
        name: String,
        baseScores: AbilityScores,
        backgroundAbilityChoices: List<Pair<String, Int>>,
        hitDie: Int
    ): String {
        val bonusMap = backgroundAbilityChoices.associate { it.first to it.second }
        val finalScores = AbilityScores(
            str = baseScores.str + (bonusMap["str"] ?: 0),
            dex = baseScores.dex + (bonusMap["dex"] ?: 0),
            con = baseScores.con + (bonusMap["con"] ?: 0),
            intelligence = baseScores.intelligence + (bonusMap["int"] ?: 0),
            wis = baseScores.wis + (bonusMap["wis"] ?: 0),
            cha = baseScores.cha + (bonusMap["cha"] ?: 0)
        )

        val conModifier = abilityModifier(finalScores.con)
        val hpMax = hitDie + conModifier

        val characterId = IdGenerator.newId()
        database.charactersQueries.insertCharacter(
            characterId, campaignId, ownerUserId, raceId, backgroundId, name,
            1L, hpMax.toLong(), hpMax.toLong(),
            finalScores.str.toLong(), finalScores.dex.toLong(), finalScores.con.toLong(),
            finalScores.intelligence.toLong(), finalScores.wis.toLong(), finalScores.cha.toLong(),
            0L, 0L
        )

        val now = currentTimeMillis()
        database.charactersQueries.insertPrimaryClass(IdGenerator.newId(), characterId, primaryClassId, 1L, now, now)

        backgroundAbilityChoices.forEach { (abilityId, bonus) ->
            database.charactersQueries.insertAbilityChoice(IdGenerator.newId(), characterId, abilityId, bonus.toLong())
        }

        return characterId
    }

    fun createCharacterFreeform(
        campaignId: String,
        ownerUserId: String,
        raceId: String,
        primaryClassId: String,
        backgroundId: String,
        name: String,
        finalScores: AbilityScores,
        hpMax: Int
    ): String {
        val characterId = IdGenerator.newId()
        database.charactersQueries.insertCharacter(
            characterId, campaignId, ownerUserId, raceId, backgroundId, name,
            1L, hpMax.toLong(), hpMax.toLong(),
            finalScores.str.toLong(), finalScores.dex.toLong(), finalScores.con.toLong(),
            finalScores.intelligence.toLong(), finalScores.wis.toLong(), finalScores.cha.toLong(),
            0L, 0L
        )
        val now = currentTimeMillis()
        database.charactersQueries.insertPrimaryClass(IdGenerator.newId(), characterId, primaryClassId, 1L, now, now)
        return characterId
    }

    fun requestMulticlass(characterId: String, classId: String, level: Int = 1) {
        database.charactersQueries.requestMulticlass(
            IdGenerator.newId(), characterId, classId, level.toLong(), currentTimeMillis()
        )
    }

    fun approveMulticlass(classEntryId: String) {
        database.charactersQueries.approveMulticlass(currentTimeMillis(), classEntryId)
    }

    fun updatePlayerHp(characterId: String, newHp: Int) {
        database.charactersQueries.updatePlayerCharacterHp(newHp.toLong(), characterId)
    }

    fun approveCharacterChanges(characterId: String) {
        database.charactersQueries.approveCharacterChanges(characterId)
    }

    fun getCharactersForCampaign(campaignId: String): List<CharacterInfo> =
        database.charactersQueries.selectCharactersByCampaign(campaignId).executeAsList().map { mapCharacter(it) }

    fun getCharacterById(id: String): CharacterInfo? =
        database.charactersQueries.selectCharacterById(id).executeAsOneOrNull()?.let { mapCharacter(it) }

    fun getClassesForCharacter(characterId: String): List<CharacterClassInfo> =
        database.charactersQueries.selectClassesForCharacter(characterId).executeAsList().map { mapClass(it) }

    fun getPendingMulticlassRequests(): List<CharacterClassInfo> =
        database.charactersQueries.selectPendingMulticlassRequests().executeAsList().map { mapClass(it) }
}