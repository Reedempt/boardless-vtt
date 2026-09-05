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

class RulesPackRepository(private val database: RulesPackDatabase) {

    fun ensureSeedData() {
        // Ogni tabella controllata e popolata indipendentemente dalle altre.
        // Ordine obbligato dove esistono foreign key: abilities prima di classes/ability_bonus_source.

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

        // Controllo specifico su un source_id noto, dato che questa tabella
        // potrà in futuro contenere righe di source_type diversi (es. 'race' per altri giochi)
        val existingBackgroundBonuses = database.abilityBonusSourceQueries
            .selectBonusesForSource("background", "bg-acolyte")
            .executeAsList()
        if (existingBackgroundBonuses.isEmpty()) {
            database.abilityBonusSourceQueries.insertSeedBackgroundBonuses()
        }
    }

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