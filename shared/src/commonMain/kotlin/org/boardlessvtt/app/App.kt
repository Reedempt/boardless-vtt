package org.boardlessvtt.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
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
import org.boardlessvtt.app.ui.LoginScreen
import org.boardlessvtt.app.ui.DropdownSelector

@Composable
fun App(driverFactory: DatabaseDriverFactory) {
    LaunchedEffect(Unit) {
        PasswordCrypto.initialize()
    }

    val authRepository = remember {
        AuthRepository(createAuthDatabase(driverFactory))
    }

    var loggedInUserId by remember { mutableStateOf<String?>(null) }
    var selectedCampaign by remember { mutableStateOf<Pair<String, String>?>(null) } // campaignId, gameId

    MaterialTheme {
        val userId = loggedInUserId
        if (userId == null) {
            LoginScreen(
                authRepository = authRepository,
                onLoginSuccess = { id -> loggedInUserId = id }
            )
        } else if (selectedCampaign == null) {
            val campaignRepository = remember {
                CampaignRepository(createBoardlessDatabase(driverFactory))
            }
            CampaignListScreen(
                campaignRepository = campaignRepository,
                currentUserId = userId,
                onCampaignSelected = { campaignId, gameId -> selectedCampaign = campaignId to gameId }
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
            CharacterCreationScreen(
                campaignId = campaignId,
                currentUserId = userId,
                isDm = true, // per ora sempre DM, dato che solo il DM crea campagne in questo flusso
                characterRepository = characterRepository,
                rulesPackRepository = rulesPackRepository,
                onCharacterCreated = { selectedCampaign = null } // torna alla lista campagne dopo la creazione
            )
        }
        /* var showContent by remember { mutableStateOf(false) }
         Column(
             modifier = Modifier
                 .background(MaterialTheme.colorScheme.primaryContainer)
                 .safeContentPadding()
                 .fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
         ) {
             Button(onClick = { showContent = !showContent }) {
                 Text("Click me!")
             }
             AnimatedVisibility(showContent) {
                 val greeting = remember { Greeting().greet() }
                 Column(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalAlignment = Alignment.CenterHorizontally,
                 ) {
                     Image(painterResource(Res.drawable.compose_multiplatform), null)
                     Text("Compose: $greeting")
                 }
             }
         } */
    }
}