package org.boardlessvtt.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.boardlessvtt.app.network.CampaignClient
import org.boardlessvtt.app.network.ServerMessage

@Composable
fun PlayerConnectionScreen(
    currentUserId: String,
    client: CampaignClient,
    onConnected: (campaignId: String, gameId: String) -> Unit,
    onLogout: () -> Unit
) {
    var hostIp by remember { mutableStateOf("") }
    var campaignId by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isConnecting by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            TextButton(onClick = onLogout) { Text("Logout") }
        }

        Text("Connettiti a una campagna", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = hostIp,
            onValueChange = { hostIp = it },
            label = { Text("IP del DM") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = campaignId,
            onValueChange = { campaignId = it.uppercase() },
            label = { Text("Codice campagna (6 caratteri)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(Modifier.height(8.dp))
        }

        Button(
            onClick = {
                if (hostIp.isBlank() || campaignId.isBlank()) {
                    errorMessage = "Inserisci IP e ID campagna"
                    return@Button
                }
                isConnecting = true
                errorMessage = null
                coroutineScope.launch {
                    try {
                        client.connect(hostIp)
                        val response = client.joinCampaign(campaignId, currentUserId)
                        when (response) {
                            is ServerMessage.JoinAccepted -> onConnected(response.campaignId, response.gameId)
                            is ServerMessage.JoinRejected -> errorMessage = response.reason
                            is ServerMessage.Error -> errorMessage = response.message
                            else -> errorMessage = "Risposta inattesa dal DM"
                        }
                    } catch (e: Exception) {
                        errorMessage = "Impossibile connettersi: ${e.message}"
                    } finally {
                        isConnecting = false
                    }
                }
            },
            enabled = !isConnecting
        ) {
            Text(if (isConnecting) "Connessione in corso..." else "Connetti")
        }
    }
}