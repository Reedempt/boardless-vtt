package org.boardlessvtt.app.ui

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
import org.boardlessvtt.app.campaign.CampaignRepository
import org.boardlessvtt.app.campaign.CampaignInfo
import org.boardlessvtt.app.campaign.GameInfo

@Composable
fun CampaignListScreen(
    campaignRepository: CampaignRepository,
    currentUserId: String
) {
    var campaigns by remember { mutableStateOf<List<CampaignInfo>>(emptyList()) }
    var games by remember { mutableStateOf<List<GameInfo>>(emptyList()) }
    var showCreateForm by remember { mutableStateOf(false) }
    var newCampaignName by remember { mutableStateOf("") }
    var selectedGameId by remember { mutableStateOf<String?>(null) }
    var campaignPendingDelete by remember { mutableStateOf<CampaignInfo?>(null) }

    fun refresh() {
        campaigns = campaignRepository.getCampaignsForDm(currentUserId)
        games = campaignRepository.getAvailableGames()
    }

    LaunchedEffect(Unit) {
        campaignRepository.ensureSeedGames()
        refresh()
    }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Le mie campagne", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        if (campaigns.isEmpty()) {
            Text("Nessuna campagna ancora creata.")
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(campaigns) { campaign ->
                    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                        Row(
                            modifier = Modifier.padding(12.dp).fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(campaign.name, style = MaterialTheme.typography.titleMedium)
                            IconButton(onClick = { campaignPendingDelete = campaign }) {
                                Icon(Icons.Default.Delete, contentDescription = "Elimina campagna")
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        if (showCreateForm) {
            OutlinedTextField(
                value = newCampaignName,
                onValueChange = { newCampaignName = it },
                label = { Text("Nome campagna") },
                singleLine = true
            )
            Spacer(Modifier.height(8.dp))
            Text("Scegli gioco:")
            games.forEach { game ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedGameId == game.id,
                        onClick = { selectedGameId = game.id }
                    )
                    Text(game.name)
                }
            }
            Spacer(Modifier.height(8.dp))
            Button(onClick = {
                val gameId = selectedGameId
                if (newCampaignName.isNotBlank() && gameId != null) {
                    campaignRepository.createCampaign(newCampaignName, gameId, currentUserId)
                    newCampaignName = ""
                    selectedGameId = null
                    showCreateForm = false
                    refresh()
                }
            }) {
                Text("Crea campagna")
            }
        } else {
            Button(onClick = { showCreateForm = true }) {
                Text("+ Nuova campagna")
            }
        }
    }

    campaignPendingDelete?.let { campaign ->
        AlertDialog(
            onDismissRequest = { campaignPendingDelete = null },
            title = { Text("Eliminare la campagna?") },
            text = { Text("Stai per eliminare \"${campaign.name}\". Questa azione non è reversibile.") },
            confirmButton = {
                TextButton(onClick = {
                    campaignRepository.deleteCampaign(campaign.id)
                    campaignPendingDelete = null
                    refresh()
                }) {
                    Text("Elimina", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { campaignPendingDelete = null }) {
                    Text("Annulla")
                }
            }
        )
    }
}