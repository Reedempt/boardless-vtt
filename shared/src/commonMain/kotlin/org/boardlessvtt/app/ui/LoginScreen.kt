package org.boardlessvtt.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.boardlessvtt.app.auth.AuthRepository

@Composable
fun LoginScreen(
    authRepository: AuthRepository,
    onLoginSuccess: (userId: String) -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isRegisterMode by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(if (isRegisterMode) "Registrazione" else "Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true
        )
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
        )
        Spacer(Modifier.height(16.dp))

        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(Modifier.height(8.dp))
        }

        Button(onClick = {
            errorMessage = null
            if (username.isBlank() || password.isBlank()) {
                errorMessage = "Compila entrambi i campi"
                return@Button
            }
            if (isRegisterMode) {
                authRepository.register(username, password, role = "PLAYER")
                    .onSuccess { errorMessage = "Registrazione completata, effettua il login" ; isRegisterMode = false }
                    .onFailure { errorMessage = it.message }
            } else {
                authRepository.login(username, password)
                    .onSuccess { userId -> onLoginSuccess(userId) }
                    .onFailure { errorMessage = it.message }
            }
        }) {
            Text(if (isRegisterMode) "Registrati" else "Accedi")
        }
        Spacer(Modifier.height(8.dp))

        TextButton(onClick = { isRegisterMode = !isRegisterMode; errorMessage = null }) {
            Text(if (isRegisterMode) "Hai già un account? Accedi" else "Non hai un account? Registrati")
        }
    }
}