package org.boardlessvtt.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.boardlessvtt.app.character.CharacterInfo
import org.boardlessvtt.app.character.CharacterRepository
import org.boardlessvtt.app.character.abilityModifier
import org.boardlessvtt.app.character.proficiencyBonus
import org.boardlessvtt.app.rulespack.RulesPackRepository

@Composable
fun CharacterDetailScreen(
    characterId: String,
    isDm: Boolean,
    characterRepository: CharacterRepository,
    rulesPackRepository: RulesPackRepository,
    onBack: () -> Unit
) {
    var character by remember { mutableStateOf<CharacterInfo?>(null) }
    var hpInput by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }

    fun refresh() {
        character = characterRepository.getCharacterById(characterId)
        hpInput = character?.hpCurrent?.toString() ?: ""
    }

    LaunchedEffect(characterId) { refresh() }

    val c = character ?: run {
        Text("Caricamento...")
        return
    }

    val race = remember(c.raceId) { rulesPackRepository.getRaceById(c.raceId) }
    val background = remember(c.backgroundId) { rulesPackRepository.getBackgroundById(c.backgroundId) }
    val classes = remember(c.id) { characterRepository.getClassesForCharacter(c.id) }
    val primaryClass = classes.firstOrNull { it.isPrimary }
    val classInfo = primaryClass?.let { rulesPackRepository.getClassById(it.classId) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp)
    ) {
        TextButton(onClick = onBack) { Text("← Personaggi") }
        Spacer(Modifier.height(8.dp))

        Text(c.name, style = MaterialTheme.typography.headlineMedium)
        Text(
            "${race?.name ?: "?"} — ${classInfo?.name ?: "?"} (Liv. ${c.level}) — ${background?.name ?: "?"}",
            style = MaterialTheme.typography.bodyMedium
        )

        if (c.pendingDmApproval) {
            Spacer(Modifier.height(8.dp))
            Card {
                Row(
                    modifier = Modifier.padding(12.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("In attesa di approvazione DM", color = MaterialTheme.colorScheme.error)
                    if (isDm) {
                        Button(onClick = {
                            characterRepository.approveCharacterChanges(c.id)
                            refresh()
                        }) {
                            Text("Approva")
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("Punteggi Caratteristica", style = MaterialTheme.typography.titleMedium)
        val abilityRows = listOf(
            "FOR" to c.str, "DES" to c.dex, "COS" to c.con,
            "INT" to c.intelligence, "SAG" to c.wis, "CAR" to c.cha
        )
        abilityRows.forEach { (label, score) ->
            val mod = abilityModifier(score)
            val modText = if (mod >= 0) "+$mod" else "$mod"
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(label)
                Text("$score ($modText)")
            }
        }

        Spacer(Modifier.height(16.dp))
        Text(
            "Bonus di Competenza: +${proficiencyBonus(c.level)}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(16.dp))
        Text("Punti Ferita", style = MaterialTheme.typography.titleMedium)
        Text("Massimi: ${c.hpMax}")

        if (isDm) {
            Text("Attuali: ${c.hpCurrent}")
        } else {
            OutlinedTextField(
                value = hpInput,
                onValueChange = { hpInput = it },
                label = { Text("HP attuali") },
                singleLine = true,
                modifier = Modifier.width(150.dp)
            )
            Spacer(Modifier.height(8.dp))
            Button(onClick = {
                val newHp = hpInput.toIntOrNull()
                if (newHp == null || newHp < 0 || newHp > c.hpMax) {
                    message = "Valore HP non valido"
                } else {
                    characterRepository.updatePlayerHp(c.id, newHp)
                    message = "Modifica inviata, in attesa di approvazione del DM"
                    refresh()
                }
            }) {
                Text("Aggiorna HP")
            }
        }

        message?.let {
            Spacer(Modifier.height(8.dp))
            Text(it, style = MaterialTheme.typography.bodySmall)
        }

        if (classes.size > 1) {
            Spacer(Modifier.height(16.dp))
            Text("Classi", style = MaterialTheme.typography.titleMedium)
            classes.forEach { cls ->
                val info = rulesPackRepository.getClassById(cls.classId)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("${info?.name ?: cls.classId} (Liv. ${cls.level})")
                    if (!cls.approvedByDm) {
                        Text(
                            if (isDm) "In attesa" else "In attesa approvazione DM",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall
                        )
                        if (isDm) {
                            TextButton(onClick = {
                                characterRepository.approveMulticlass(cls.id)
                                // refresh non aggiorna 'classes' automaticamente qui, serve un LaunchedEffect dedicato in futuro
                            }) {
                                Text("Approva")
                            }
                        }
                    }
                }
            }
        }
    }
}