package org.boardlessvtt.app.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.json.Json

class CampaignClient(private val scope: CoroutineScope) {

    private val client = HttpClient(CIO) {
        install(WebSockets)
    }
    private val json = Json { ignoreUnknownKeys = true }
    private var session: DefaultClientWebSocketSession? = null

    val incomingMessages = Channel<ServerMessage>(Channel.UNLIMITED)

    suspend fun connect(hostIp: String, port: Int = NetworkConfig.DEFAULT_PORT) {
        session = client.webSocketSession(host = hostIp, port = port, path = "/campaign")
        scope.launch {
            session?.incoming?.let { incoming ->
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        val text = frame.readText()
                        val message = json.decodeFromString<ServerMessage>(text)
                        incomingMessages.send(message)
                    }
                }
            }
        }
    }

    suspend fun send(message: ClientMessage) {
        val text = json.encodeToString(ClientMessage.serializer(), message)
        session?.send(Frame.Text(text))
    }

    fun close() {
        client.close()
    }
}