package org.boardlessvtt.app.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO as ClientCIO
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.server.application.Application
import io.ktor.server.cio.CIO as ServerCIO
import io.ktor.server.engine.EmbeddedServer
import io.ktor.server.engine.embeddedServer

actual fun createPlatformHttpClient(): HttpClient = HttpClient(ClientCIO) {
    install(WebSockets)
}

actual fun createPlatformServer(
    port: Int,
    configure: Application.() -> Unit
): EmbeddedServer<*, *> = embeddedServer(ServerCIO, port = port, module = configure)