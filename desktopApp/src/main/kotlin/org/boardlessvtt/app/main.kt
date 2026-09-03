package org.boardlessvtt.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.boardlessvtt.app.db.DatabaseDriverFactory

fun main() = application {
    val driverFactory = DatabaseDriverFactory()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Boardless VTT",
    ) {
        App(driverFactory)
    }
}