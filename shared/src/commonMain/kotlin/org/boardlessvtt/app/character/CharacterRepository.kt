package org.boardlessvtt.app.character

import org.boardlessvtt.app.db.BoardlessDatabase
import org.boardlessvtt.app.util.IdGenerator
import org.boardlessvtt.app.util.currentTimeMillis

data class AbilityScores(
    val str: Int, val dex: Int, val con: Int,
    val intelligence: Int, val wis: Int, val cha: Int
)

class CharacterRepository(private val database: BoardlessDatabase) {

    /**
     * Valida una distribuzione Point Buy contro il budget disponibile.
     * Ritorna il costo totale speso, o null se la distribuzione eccede il cap per punteggio.
     */
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
        backgroundAbilityChoices: List<Pair<String, Int>>, // (abilityId, bonusAmount)
        hitDie: Int
    ): String {
        // Applica i bonus del background ai punteggi base
        val bonusMap = backgroundAbilityChoices.associate { it.first to it.second }
        val finalScores = AbilityScores(
            str = baseScores.str + (bonusMap["str"] ?: 0),
            dex = baseScores.dex + (bonusMap["dex"] ?: 0),
            con = baseScores.con + (bonusMap["con"] ?: 0),
            intelligence = baseScores.intelligence + (bonusMap["int"] ?: 0),
            wis = baseScores.wis + (bonusMap["wis"] ?: 0),
            cha = baseScores.cha + (bonusMap["cha"] ?: 0)
        )

        val conModifier = (finalScores.con - 10) / 2 // divisione intera, coerente con regole D&D
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

    /**
     * Creazione libera per il DM: nessuna validazione Point Buy, punteggi finali già decisi.
     */
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

    fun getPendingMulticlassRequests() =
        database.charactersQueries.selectPendingMulticlassRequests().executeAsList()

    fun getCharactersForCampaign(campaignId: String) =
        database.charactersQueries.selectCharactersByCampaign(campaignId).executeAsList()
}