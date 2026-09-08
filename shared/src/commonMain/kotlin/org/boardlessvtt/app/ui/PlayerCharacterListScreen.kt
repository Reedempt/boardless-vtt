package org.boardlessvtt.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.boardlessvtt.app.network.CampaignClient
import org.boardlessvtt.app.network.NetworkCharacter
import org.boardlessvtt.app.network.ServerMessage

@Composable
fun PlayerCharacterListScreen(
    campaignId: String,
    client: CampaignClient,
    onBack: () -> Unit,
    onCreateNewCharacter: () -> Unit
) {
    var characters by remember { mutableStateOf<List<NetworkCharacter>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    fun refresh() {
        coroutineScope.launch {
            try {
                val response = client.getCharacters(campaignId)
                when (response) {
                    is ServerMessage.CharactersList -> characters = response.characters
                    is ServerMessage.Error -> errorMessage = response.message
                    else -> errorMessage = "Risposta inattesa dal DM"
                }
            } catch (e: Exception) {
                errorMessage = "Errore di connessione: ${e.message}"
            }
        }
    }

    LaunchedEffect(campaignId) { refresh() }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        TextButton(onClick = onBack) { Text("← Disconnetti") }
        Spacer(Modifier.height(8.dp))

        Text("Personaggi (campagna remota)", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(Modifier.height(8.dp))
        }

        if (characters.isEmpty()) {
            Text("Nessun personaggio ancora creato.")
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(characters) { character ->
                    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(character.name, style = MaterialTheme.typography.titleMedium)
                            Text("Livello ${character.level} — HP ${character.hpCurrent}/${character.hpMax}")
                            if (character.pendingDmApproval) {
                                Text(
                                    "In attesa di approvazione",
                                    color = MaterialTheme.colorScheme.error,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { refresh() }) { Text("Aggiorna") }
            Button(onClick = onCreateNewCharacter) { Text("+ Nuovo Personaggio") }
        }
    }
}