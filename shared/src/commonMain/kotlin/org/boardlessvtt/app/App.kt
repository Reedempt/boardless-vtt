package org.boardlessvtt.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.boardlessvtt.app.auth.AuthRepository
import org.boardlessvtt.app.campaign.CampaignRepository
import org.boardlessvtt.app.character.CharacterRepository
import org.boardlessvtt.app.db.DatabaseDriverFactory
import org.boardlessvtt.app.db.createAuthDatabase
import org.boardlessvtt.app.db.createBoardlessDatabase
import org.boardlessvtt.app.db.createRulesPackDatabase
import org.boardlessvtt.app.rulespack.RulesPackRepository
import org.boardlessvtt.app.security.PasswordCrypto
import org.boardlessvtt.app.ui.CampaignListScreen
import org.boardlessvtt.app.ui.CharacterCreationScreen
import org.boardlessvtt.app.ui.CharacterDetailScreen
import org.boardlessvtt.app.ui.CharacterListScreen
import org.boardlessvtt.app.ui.LoginScreen
import org.boardlessvtt.app.network.CampaignServer
import org.boardlessvtt.app.network.CampaignClient
import org.boardlessvtt.app.ui.PlayerConnectionScreen
import org.boardlessvtt.app.ui.PlayerCharacterListScreen

@Composable
fun App(driverFactory: DatabaseDriverFactory) {
    LaunchedEffect(Unit) {
        PasswordCrypto.initialize()
    }

    val authRepository = remember {
        AuthRepository(createAuthDatabase(driverFactory))
    }

    var loggedInUserId by remember { mutableStateOf<String?>(null) }
    var loggedInRole by remember { mutableStateOf<String?>(null) }
    var selectedCampaign by remember { mutableStateOf<Pair<String, String>?>(null) } // campaignId, gameId
    var selectedCharacterId by remember { mutableStateOf<String?>(null) }
    var showCharacterCreation by remember { mutableStateOf(false) }

    MaterialTheme {
        val userId = loggedInUserId
        if (userId == null) {
            LoginScreen(
                authRepository = authRepository,
                onLoginSuccess = { id, role ->
                    loggedInUserId = id
                    loggedInRole = role
                }
            )
        } else if (loggedInRole == "PLAYER") {
            val coroutineScope = rememberCoroutineScope()
            val client = remember { CampaignClient(coroutineScope) }
            var connectedCampaignId by remember { mutableStateOf<String?>(null) }

            val campId = connectedCampaignId
            if (campId == null) {
                PlayerConnectionScreen(
                    currentUserId = userId,
                    client = client,
                    onConnected = { id -> connectedCampaignId = id },
                    onLogout = { loggedInUserId = null; loggedInRole = null }
                )
            } else {
                PlayerCharacterListScreen(
                    campaignId = campId,
                    client = client,
                    onBack = { connectedCampaignId = null }
                )
            }
        } else if (selectedCampaign == null) {
            val campaignRepository = remember {
                CampaignRepository(createBoardlessDatabase(driverFactory))
            }
            val characterRepositoryForServer = remember { CharacterRepository(createBoardlessDatabase(driverFactory)) }
            val campaignRepositoryForServer = remember { CampaignRepository(createBoardlessDatabase(driverFactory)) }
            val campaignServer = remember { CampaignServer(characterRepositoryForServer, campaignRepositoryForServer) }
            LaunchedEffect(Unit) {
                campaignServer.start()
            }
            CampaignListScreen(
                campaignRepository = campaignRepository,
                currentUserId = userId,
                onCampaignSelected = { campaignId, gameId -> selectedCampaign = campaignId to gameId },
                onLogout = { loggedInUserId = null; loggedInRole = null }
            )
        } else {
            val (campaignId, gameId) = selectedCampaign!!
            val characterRepository = remember {
                CharacterRepository(createBoardlessDatabase(driverFactory))
            }
            val rulesPackRepository = remember(gameId) {
                val db = createRulesPackDatabase(driverFactory, gameId)
                RulesPackRepository(db).also { it.ensureSeedData() }
            }

            val charId = selectedCharacterId
            if (charId != null) {
                CharacterDetailScreen(
                    characterId = charId,
                    isDm = loggedInRole == "DM",
                    characterRepository = characterRepository,
                    rulesPackRepository = rulesPackRepository,
                    onBack = { selectedCharacterId = null }
                )
            } else if (showCharacterCreation) {
                CharacterCreationScreen(
                    campaignId = campaignId,
                    currentUserId = userId,
                    isDm = loggedInRole == "DM",
                    characterRepository = characterRepository,
                    rulesPackRepository = rulesPackRepository,
                    onCharacterCreated = { showCharacterCreation = false },
                    onCancel = { showCharacterCreation = false }
                )
            } else {
                CharacterListScreen(
                    campaignId = campaignId,
                    characterRepository = characterRepository,
                    onCharacterSelected = { id -> selectedCharacterId = id },
                    onCreateNewCharacter = { showCharacterCreation = true },
                    onBack = { selectedCampaign = null }
                )
            }
        }
    }
}