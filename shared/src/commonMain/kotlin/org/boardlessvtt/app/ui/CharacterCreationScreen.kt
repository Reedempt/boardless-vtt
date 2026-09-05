package org.boardlessvtt.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.boardlessvtt.app.character.AbilityScores
import org.boardlessvtt.app.character.CharacterRepository
import org.boardlessvtt.app.rulespack.*

@Composable
fun CharacterCreationScreen(
    campaignId: String,
    currentUserId: String,
    isDm: Boolean,
    characterRepository: CharacterRepository,
    rulesPackRepository: RulesPackRepository,
    onCharacterCreated: () -> Unit
) {
    val races = remember { rulesPackRepository.getAllRaces() }
    val classes = remember { rulesPackRepository.getAllClasses() }
    val backgrounds = remember { rulesPackRepository.getAllBackgrounds() }
    val pointBuyConfig = remember { rulesPackRepository.getPointBuyConfig() }
    val pointBuyCosts = remember { rulesPackRepository.getPointBuyCosts() }

    var name by remember { mutableStateOf("") }
    var selectedRace by remember { mutableStateOf<RaceInfo?>(null) }
    var selectedClass by remember { mutableStateOf<ClassInfo?>(null) }
    var selectedBackground by remember { mutableStateOf<BackgroundInfo?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val baseScore = pointBuyConfig?.baseScore?.toInt() ?: 8
    var scores by remember {
        mutableStateOf(mapOf("str" to baseScore, "dex" to baseScore, "con" to baseScore, "int" to baseScore, "wis" to baseScore, "cha" to baseScore))
    }

    // Bonus background: quali abilità sono idonee, e quanto assegnare a ciascuna (max 3 punti totali)
    val eligibleAbilities = selectedBackground?.let { rulesPackRepository.getEligibleAbilitiesForBackground(it.id) } ?: emptyList()
    var backgroundBonuses by remember(selectedBackground) {
        mutableStateOf(eligibleAbilities.associate { it.abilityId to 0 })
    }

    val spentPoints = scores.values.sumOf { pointBuyCosts[it] ?: 0 }
    val maxPoints = pointBuyConfig?.maxPoints?.toInt() ?: 27
    val remainingPoints = maxPoints - spentPoints
    val backgroundPointsUsed = backgroundBonuses.values.sum()

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp)
    ) {
        Text("Nuovo Personaggio", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome personaggio") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        DropdownSelector(
            label = "Specie",
            options = races,
            selectedOption = selectedRace,
            optionLabel = { it.name },
            onOptionSelected = { selectedRace = it }
        )
        Spacer(Modifier.height(16.dp))

        DropdownSelector(
            label = "Classe",
            options = classes,
            selectedOption = selectedClass,
            optionLabel = { "${it.name} (d${it.hitDie})" },
            onOptionSelected = { selectedClass = it }
        )
        Spacer(Modifier.height(16.dp))

        DropdownSelector(
            label = "Background",
            options = backgrounds,
            selectedOption = selectedBackground,
            optionLabel = { it.name },
            onOptionSelected = { selectedBackground = it }
        )
        Spacer(Modifier.height(16.dp))

        if (!isDm) {
            Text("Point Buy — Punti rimanenti: $remainingPoints / $maxPoints", style = MaterialTheme.typography.titleMedium)
            scores.forEach { (ability, value) ->
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    Text(ability.uppercase(), modifier = Modifier.width(60.dp))
                    IconButtonMinus {
                        val newVal = value - 1
                        if (newVal >= baseScore) scores = scores + (ability to newVal)
                    }
                    Text("$value", modifier = Modifier.width(30.dp))
                    IconButtonPlus {
                        val newVal = value + 1
                        val cap = pointBuyConfig?.scoreCap?.toInt() ?: 15
                        if (newVal <= cap && (pointBuyCosts[newVal] ?: Int.MAX_VALUE) <= maxPoints) {
                            scores = scores + (ability to newVal)
                        }
                    }
                }
            }
        } else {
            Text("Modalità DM — inserimento libero", style = MaterialTheme.typography.titleMedium)
            scores.forEach { (ability, value) ->
                OutlinedTextField(
                    value = value.toString(),
                    onValueChange = { text -> text.toIntOrNull()?.let { scores = scores + (ability to it) } },
                    label = { Text(ability.uppercase()) },
                    modifier = Modifier.width(120.dp).padding(vertical = 4.dp)
                )
            }
        }

        if (eligibleAbilities.isNotEmpty()) {
            Spacer(Modifier.height(16.dp))
            Text("Bonus Background — punti usati: $backgroundPointsUsed / 3", style = MaterialTheme.typography.titleMedium)
            eligibleAbilities.forEach { choice ->
                val current = backgroundBonuses[choice.abilityId] ?: 0
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    Text(choice.abilityId.uppercase(), modifier = Modifier.width(60.dp))
                    IconButtonMinus {
                        if (current > 0) backgroundBonuses = backgroundBonuses + (choice.abilityId to current - 1)
                    }
                    Text("$current", modifier = Modifier.width(30.dp))
                    IconButtonPlus {
                        if (backgroundPointsUsed < 3 && current < 2) {
                            backgroundBonuses = backgroundBonuses + (choice.abilityId to current + 1)
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(Modifier.height(8.dp))
        }

        Button(onClick = {
            errorMessage = null
            val race = selectedRace
            val cls = selectedClass
            val bg = selectedBackground

            if (name.isBlank() || race == null || cls == null || bg == null) {
                errorMessage = "Compila tutti i campi obbligatori"
                return@Button
            }
            if (!isDm && backgroundPointsUsed != 3) {
                errorMessage = "Distribuisci esattamente 3 punti bonus dal background"
                return@Button
            }
            if (!isDm && remainingPoints != 0) {
                errorMessage = "Devi spendere esattamente $maxPoints punti (rimangono $remainingPoints)"
                return@Button
            }

            val abilityScores = AbilityScores(
                str = scores["str"]!!, dex = scores["dex"]!!, con = scores["con"]!!,
                intelligence = scores["int"]!!, wis = scores["wis"]!!, cha = scores["cha"]!!
            )

            if (isDm) {
                val conMod = (abilityScores.con - 10) / 2
                val hpMax = cls.hitDie.toInt() + conMod
                characterRepository.createCharacterFreeform(
                    campaignId, currentUserId, race.id, cls.id, bg.id, name, abilityScores, hpMax
                )
            } else {
                characterRepository.createCharacterWithPointBuy(
                    campaignId, currentUserId, race.id, cls.id, bg.id, name, abilityScores,
                    backgroundBonuses.filter { it.value > 0 }.map { it.key to it.value },
                    cls.hitDie.toInt()
                )
            }
            onCharacterCreated()
        }) {
            Text("Crea Personaggio")
        }
    }
}

@Composable
private fun IconButtonMinus(onClick: () -> Unit) {
    TextButton(onClick = onClick) { Text("−") }
}

@Composable
private fun IconButtonPlus(onClick: () -> Unit) {
    TextButton(onClick = onClick) { Text("+") }
}