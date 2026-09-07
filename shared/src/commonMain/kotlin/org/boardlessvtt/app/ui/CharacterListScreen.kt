package org.boardlessvtt.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.boardlessvtt.app.character.CharacterInfo
import org.boardlessvtt.app.character.CharacterRepository

@Composable
fun CharacterListScreen(
    campaignId: String,
    characterRepository: CharacterRepository,
    onCharacterSelected: (characterId: String) -> Unit,
    onCreateNewCharacter: () -> Unit,
    onBack: () -> Unit
) {
    var characters by remember { mutableStateOf<List<CharacterInfo>>(emptyList()) }
    var characterPendingDelete by remember { mutableStateOf<CharacterInfo?>(null) }

    fun refresh() {
        characters = characterRepository.getCharactersForCampaign(campaignId)
    }

    LaunchedEffect(campaignId) { refresh() }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = onBack) { Text("← Campagne") }
        }
        Spacer(Modifier.height(8.dp))

        Text("Personaggi", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        if (characters.isEmpty()) {
            Text("Nessun personaggio ancora creato.")
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(characters) { character ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable { onCharacterSelected(character.id) }
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp).fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(character.name, style = MaterialTheme.typography.titleMedium)
                                Text("Livello ${character.level}", style = MaterialTheme.typography.bodySmall)
                                if (character.pendingDmApproval) {
                                    Text(
                                        "In attesa di approvazione",
                                        color = MaterialTheme.colorScheme.error,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                            }
                            IconButton(onClick = { characterPendingDelete = character }) {
                                Icon(Icons.Default.Delete, contentDescription = "Elimina personaggio")
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Button(onClick = onCreateNewCharacter) {
            Text("+ Nuovo Personaggio")
        }
    }

    characterPendingDelete?.let { character ->
        AlertDialog(
            onDismissRequest = { characterPendingDelete = null },
            title = { Text("Eliminare il personaggio?") },
            text = { Text("Stai per eliminare \"${character.name}\". Questa azione non è reversibile.") },
            confirmButton = {
                TextButton(onClick = {
                    characterRepository.deleteCharacter(character.id)
                    characterPendingDelete = null
                    refresh()
                }) {
                    Text("Elimina", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { characterPendingDelete = null }) {
                    Text("Annulla")
                }
            }
        )
    }
}