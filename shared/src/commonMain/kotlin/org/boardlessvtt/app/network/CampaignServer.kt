package org.boardlessvtt.app.network

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class CampaignServer(private val port: Int = NetworkConfig.DEFAULT_PORT) {

    private var server: EmbeddedServer<*, *>? = null

    fun start() {
        server = embeddedServer(CIO, port = port) {
            routing {
                get("/ping") {
                    call.respondText("pong")
                }
            }
        }.also { it.start(wait = false) }
    }

    fun stop() {
        server?.stop(1000, 2000)
        server = null
    }
}