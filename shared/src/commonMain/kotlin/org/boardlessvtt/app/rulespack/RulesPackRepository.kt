package org.boardlessvtt.app.rulespack

data class RaceInfo(
    val id: String,
    val name: String,
    val description: String?,
    val speed: Long,
    val size: String
)

data class ClassInfo(
    val id: String,
    val name: String,
    val hitDie: Long,
    val primaryAbilityId: String,
    val description: String?
)

data class AbilityInfo(
    val id: String,
    val name: String,
    val abbreviation: String
)

data class BackgroundInfo(
    val id: String,
    val name: String,
    val description: String?
)

data class AbilityBonusChoice(
    val id: String,
    val sourceType: String,
    val sourceId: String,
    val abilityId: String
)

data class PointBuyConfig(
    val baseScore: Long,
    val maxPoints: Long,
    val scoreCap: Long
)

class RulesPackRepository(private val database: RulesPackDatabase) {

    fun ensureSeedData() {
        if (database.abilitiesQueries.selectAllAbilities().executeAsList().isEmpty()) {
            val abilities = listOf(
                Triple("str", "Forza", "STR"),
                Triple("dex", "Destrezza", "DEX"),
                Triple("con", "Costituzione", "CON"),
                Triple("int", "Intelligenza", "INT"),
                Triple("wis", "Saggezza", "WIS"),
                Triple("cha", "Carisma", "CHA")
            )
            abilities.forEach { (id, name, abbr) ->
                database.abilitiesQueries.insertAbility(id, name, abbr)
            }
        }

        if (database.racesQueries.selectAllRaces().executeAsList().isEmpty()) {
            database.racesQueries.insertSeedRaces()
        }

        if (database.classesQueries.selectAllClasses().executeAsList().isEmpty()) {
            database.classesQueries.insertSeedClasses()
        }

        if (database.backgroundsQueries.selectAllBackgrounds().executeAsList().isEmpty()) {
            database.backgroundsQueries.insertSeedBackgrounds()
        }

        val existingBackgroundBonuses = database.abilityBonusSourceQueries
            .selectBonusesForSource("background", "bg-acolyte")
            .executeAsList()
        if (existingBackgroundBonuses.isEmpty()) {
            database.abilityBonusSourceQueries.insertSeedBackgroundBonuses()
        }

        if (database.pointBuyQueries.selectPointBuyConfig().executeAsOneOrNull() == null) {
            database.pointBuyQueries.insertSeedPointBuy()
            val costs = listOf(
                8L to 0L, 9L to 1L, 10L to 2L, 11L to 3L, 12L to 4L,
                13L to 5L, 14L to 7L, 15L to 9L
            )
            costs.forEach { (score, cost) ->
                database.pointBuyQueries.insertPointBuyCost(score, cost)
            }
        }
    }

    fun getPointBuyConfig(): PointBuyConfig? {
        val row = database.pointBuyQueries.selectPointBuyConfig().executeAsOneOrNull()
        return row?.let {
            PointBuyConfig(baseScore = it.base_score, maxPoints = it.max_points, scoreCap = it.score_cap)
        }
    }

    fun getPointBuyCosts(): Map<Int, Int> =
        database.pointBuyQueries.selectAllPointBuyCosts().executeAsList()
            .associate { it.score.toInt() to it.cumulative_cost.toInt() }

    fun getAllRaces(): List<RaceInfo> =
        database.racesQueries.selectAllRaces().executeAsList().map {
            RaceInfo(
                id = it.id,
                name = it.name,
                description = it.description,
                speed = it.speed,
                size = it.size
            )
        }

    fun getAllClasses(): List<ClassInfo> =
        database.classesQueries.selectAllClasses().executeAsList().map {
            ClassInfo(
                id = it.id,
                name = it.name,
                hitDie = it.hit_die,
                primaryAbilityId = it.primary_ability_id,
                description = it.description
            )
        }

    fun getAllAbilities(): List<AbilityInfo> =
        database.abilitiesQueries.selectAllAbilities().executeAsList().map {
            AbilityInfo(
                id = it.id,
                name = it.name,
                abbreviation = it.abbreviation
            )
        }

    fun getAllBackgrounds(): List<BackgroundInfo> =
        database.backgroundsQueries.selectAllBackgrounds().executeAsList().map {
            BackgroundInfo(
                id = it.id,
                name = it.name,
                description = it.description
            )
        }

    fun getEligibleAbilitiesForBackground(backgroundId: String): List<AbilityBonusChoice> =
        database.abilityBonusSourceQueries.selectBonusesForSource("background", backgroundId).executeAsList().map {
            AbilityBonusChoice(
                id = it.id,
                sourceType = it.source_type,
                sourceId = it.source_id,
                abilityId = it.ability_id
            )
        }
}