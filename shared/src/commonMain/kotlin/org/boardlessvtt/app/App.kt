package org.boardlessvtt.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import org.boardlessvtt.app.db.DatabaseDriverFactory
import org.boardlessvtt.app.db.createAuthDatabase
import org.boardlessvtt.app.ui.LoginScreen
import org.boardlessvtt.app.security.PasswordCrypto
import org.boardlessvtt.app.auth.AuthRepository

@Composable
fun App(driverFactory: DatabaseDriverFactory) {
    LaunchedEffect(Unit) {
        PasswordCrypto.initialize()
    }
    val authRepository = remember {
        AuthRepository (createAuthDatabase(driverFactory))
    }
    var loggedInUserId by remember { mutableStateOf<String?>(null) }
    MaterialTheme {
        if (loggedInUserId == null) {
            LoginScreen(
                authRepository = authRepository,
                onLoginSuccess = { userId -> loggedInUserId = userId }
            )
        } else {
            Text("Benvenuto! User ID: $loggedInUserId")
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