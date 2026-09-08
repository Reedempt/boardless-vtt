package org.boardlessvtt.app.network

import io.ktor.client.*
import io.ktor.server.engine.*

expect fun createPlatformHttpClient(): HttpClient

expect fun createPlatformServer(
    port: Int,
    configure: io.ktor.server.application.Application.() -> Unit
): EmbeddedServer<*, *>