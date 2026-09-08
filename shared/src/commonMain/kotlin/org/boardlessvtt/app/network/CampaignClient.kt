package org.boardlessvtt.app.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.boardlessvtt.app.util.IdGenerator

class CampaignClient(private val scope: CoroutineScope) {

    private val client = HttpClient(CIO) { install(WebSockets) }
    private val json = Json { ignoreUnknownKeys = true }
    private var session: DefaultClientWebSocketSession? = null

    private val pendingRequests = mutableMapOf<String, CompletableDeferred<ServerMessage>>()

    suspend fun connect(hostIp: String, port: Int = NetworkConfig.DEFAULT_PORT) {
        session = client.webSocketSession(host = hostIp, port = port, path = "/campaign")
        scope.launch {
            session?.incoming?.let { incoming ->
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        val message = json.decodeFromString<ServerMessage>(frame.readText())
                        val reqId = message.requestId
                        if (reqId != null) {
                            pendingRequests.remove(reqId)?.complete(message)
                        }
                        // messaggi senza requestId sono notifiche push — gestione futura
                    }
                }
            }
        }
    }
    private suspend fun sendAndAwait(message: ClientMessage): ServerMessage {
        val deferred = CompletableDeferred<ServerMessage>()
        pendingRequests[message.requestId] = deferred
        val text = json.encodeToString(ClientMessage.serializer(), message)
        session?.send(Frame.Text(text)) ?: run {
            pendingRequests.remove(message.requestId)
            throw IllegalStateException("Non connesso")
        }
        return deferred.await()
    }

    suspend fun joinCampaign(joinCode: String, userId: String): ServerMessage =
        sendAndAwait(ClientMessage.JoinCampaign(IdGenerator.newId(), joinCode, userId))

    suspend fun getCharacters(campaignId: String): ServerMessage =
        sendAndAwait(ClientMessage.GetCharacters(IdGenerator.newId(), campaignId))

    suspend fun createCharacter(msg: ClientMessage.CreateCharacter): ServerMessage =
        sendAndAwait(msg.copy(requestId = IdGenerator.newId()))

    suspend fun updateHp(characterId: String, newHp: Int): ServerMessage =
        sendAndAwait(ClientMessage.UpdateHp(IdGenerator.newId(), characterId, newHp))

    fun close() {
        client.close()
    }
}