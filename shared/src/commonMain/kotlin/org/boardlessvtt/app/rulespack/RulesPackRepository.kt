package org.boardlessvtt.app.rulespack

data class RaceInfo(val id: String, val name: String, val description: String?, val speed: Long, val size: String)
data class ClassInfo(val id: String, val name: String, val hitDie: Long, val primaryAbilityId: String, val description: String?)
data class AbilityInfo(val id: String, val name: String, val abbreviation: String)

class RulesPackRepository(private val database: RulesPackDatabase) {

    fun ensureSeedData() {
        val existingAbilities = database.abilitiesQueries.selectAllAbilities().executeAsList()
        if (existingAbilities.isNotEmpty()) return // già popolato, non rifare nulla

        // Ordine obbligato: abilities prima (referenziate da classes)
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

        database.racesQueries.insertSeedRaces()
        database.classesQueries.insertSeedClasses()
    }

    fun getAllRaces(): List<RaceInfo> =
        database.racesQueries.selectAllRaces().executeAsList().map {
            RaceInfo(id = it.id, name = it.name, description = it.description, speed = it.speed, size = it.size)
        }

    fun getAllClasses(): List<ClassInfo> =
        database.classesQueries.selectAllClasses().executeAsList().map {
            ClassInfo(id = it.id, name = it.name, hitDie = it.hit_die, primaryAbilityId = it.primary_ability_id, description = it.description)
        }

    fun getAllAbilities(): List<AbilityInfo> =
        database.abilitiesQueries.selectAllAbilities().executeAsList().map {
            AbilityInfo(id = it.id, name = it.name, abbreviation = it.abbreviation)
        }
}