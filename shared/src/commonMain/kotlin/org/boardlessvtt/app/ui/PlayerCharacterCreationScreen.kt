package org.boardlessvtt.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.boardlessvtt.app.network.CampaignClient
import org.boardlessvtt.app.network.ServerMessage
import org.boardlessvtt.app.rulespack.*

@Composable
fun PlayerCharacterCreationScreen(
    campaignId: String,
    currentUserId: String,
    client: CampaignClient,
    rulesPackRepository: RulesPackRepository,
    onCharacterCreated: () -> Unit,
    onCancel: () -> Unit
) {
    val races = remember { rulesPackRepository.getAllRaces() }
    val classes = remember { rulesPackRepository.getAllClasses() }
    val backgrounds = remember { rulesPackRepository.getAllBackgrounds() }
    val pointBuyConfig = remember { rulesPackRepository.getPointBuyConfig() }
    val pointBuyCosts = remember { rulesPackRepository.getPointBuyCosts() }
    val coroutineScope = rememberCoroutineScope()

    var name by remember { mutableStateOf("") }
    var selectedRace by remember { mutableStateOf<RaceInfo?>(null) }
    var selectedClass by remember { mutableStateOf<ClassInfo?>(null) }
    var selectedBackground by remember { mutableStateOf<BackgroundInfo?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isSubmitting by remember { mutableStateOf(false) }
    var showCancelConfirmDialog by remember { mutableStateOf(false) }

    val baseScore = pointBuyConfig?.baseScore?.toInt() ?: 8
    var scores by remember {
        mutableStateOf(mapOf("str" to baseScore, "dex" to baseScore, "con" to baseScore, "int" to baseScore, "wis" to baseScore, "cha" to baseScore))
    }

    val eligibleAbilities = selectedBackground?.let { rulesPackRepository.getEligibleAbilitiesForBackground(it.id) } ?: emptyList()
    var backgroundBonuses by remember(selectedBackground) {
        mutableStateOf(eligibleAbilities.associate { it.abilityId to 0 })
    }

    val spentPoints = scores.values.sumOf { pointBuyCosts[it] ?: 0 }
    val maxPoints = pointBuyConfig?.maxPoints?.toInt() ?: 27
    val remainingPoints = maxPoints - spentPoints
    val backgroundPointsUsed = backgroundBonuses.values.sum()

    fun resetForm() {
        name = ""
        selectedRace = null
        selectedClass = null
        selectedBackground = null
        scores = mapOf("str" to baseScore, "dex" to baseScore, "con" to baseScore, "int" to baseScore, "wis" to baseScore, "cha" to baseScore)
        backgroundBonuses = emptyMap()
        errorMessage = null
    }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(onClick = { showCancelConfirmDialog = true }) { Text("Annulla") }
            TextButton(onClick = { resetForm() }) { Text("Reset") }
        }
        Spacer(Modifier.height(8.dp))

        Text("Nuovo Personaggio", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = name, onValueChange = { name = it },
            label = { Text("Nome personaggio") }, singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        DropdownSelector(label = "Specie", options = races, selectedOption = selectedRace,
            optionLabel = { it.name }, onOptionSelected = { selectedRace = it })
        Spacer(Modifier.height(16.dp))

        DropdownSelector(label = "Classe", options = classes, selectedOption = selectedClass,
            optionLabel = { "${it.name} (d${it.hitDie})" }, onOptionSelected = { selectedClass = it })
        Spacer(Modifier.height(16.dp))

        DropdownSelector(label = "Background", options = backgrounds, selectedOption = selectedBackground,
            optionLabel = { it.name }, onOptionSelected = { selectedBackground = it })
        Spacer(Modifier.height(16.dp))

        Text("Point Buy — Punti rimanenti: $remainingPoints / $maxPoints", style = MaterialTheme.typography.titleMedium)
        scores.forEach { (ability, value) ->
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Text(ability.uppercase(), modifier = Modifier.width(60.dp))
                TextButton(onClick = {
                    val newVal = value - 1
                    if (newVal >= baseScore) scores = scores + (ability to newVal)
                }) { Text("−") }
                Text("$value", modifier = Modifier.width(30.dp))
                TextButton(onClick = {
                    val newVal = value + 1
                    val cap = pointBuyConfig?.scoreCap?.toInt() ?: 15
                    if (newVal <= cap && (pointBuyCosts[newVal] ?: Int.MAX_VALUE) <= maxPoints) {
                        scores = scores + (ability to newVal)
                    }
                }) { Text("+") }
            }
        }

        if (eligibleAbilities.isNotEmpty()) {
            Spacer(Modifier.height(16.dp))
            Text("Bonus Background — punti usati: $backgroundPointsUsed / 3", style = MaterialTheme.typography.titleMedium)
            eligibleAbilities.forEach { choice ->
                val current = backgroundBonuses[choice.abilityId] ?: 0
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    Text(choice.abilityId.uppercase(), modifier = Modifier.width(60.dp))
                    TextButton(onClick = {
                        if (current > 0) backgroundBonuses = backgroundBonuses + (choice.abilityId to current - 1)
                    }) { Text("−") }
                    Text("$current", modifier = Modifier.width(30.dp))
                    TextButton(onClick = {
                        if (backgroundPointsUsed < 3 && current < 2) {
                            backgroundBonuses = backgroundBonuses + (choice.abilityId to current + 1)
                        }
                    }) { Text("+") }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(Modifier.height(8.dp))
        }

        Button(
            enabled = !isSubmitting,
            onClick = {
                errorMessage = null
                val race = selectedRace
                val cls = selectedClass
                val bg = selectedBackground

                if (name.isBlank() || race == null || cls == null || bg == null) {
                    errorMessage = "Compila tutti i campi obbligatori"
                    return@Button
                }
                if (backgroundPointsUsed != 3) {
                    errorMessage = "Distribuisci esattamente 3 punti bonus dal background"
                    return@Button
                }
                if (remainingPoints != 0) {
                    errorMessage = "Devi spendere esattamente $maxPoints punti (rimangono $remainingPoints)"
                    return@Button
                }

                isSubmitting = true
                coroutineScope.launch {
                    try {
                        val response = client.createCharacter(
                            campaignId = campaignId, ownerUserId = currentUserId,
                            raceId = race.id, classId = cls.id, backgroundId = bg.id, name = name,
                            str = scores["str"]!!, dex = scores["dex"]!!, con = scores["con"]!!,
                            intelligence = scores["int"]!!, wis = scores["wis"]!!, cha = scores["cha"]!!,
                            backgroundAbilityChoices = backgroundBonuses.filter { it.value > 0 },
                            hitDie = cls.hitDie.toInt()
                        )
                        when (response) {
                            is ServerMessage.CharacterUpdated -> onCharacterCreated()
                            is ServerMessage.Error -> errorMessage = response.message
                            else -> errorMessage = "Risposta inattesa dal DM"
                        }
                    } catch (e: Exception) {
                        errorMessage = "Errore di connessione: ${e.message}"
                    } finally {
                        isSubmitting = false
                    }
                }
            }
        ) {
            Text(if (isSubmitting) "Invio in corso..." else "Crea Personaggio")
        }
    }

    if (showCancelConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showCancelConfirmDialog = false },
            title = { Text("Annullare la creazione?") },
            text = { Text("Tutte le scelte fatte finora andranno perse.") },
            confirmButton = {
                TextButton(onClick = { showCancelConfirmDialog = false; onCancel() }) {
                    Text("Annulla creazione", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { showCancelConfirmDialog = false }) { Text("Continua a modificare") }
            }
        )
    }
}