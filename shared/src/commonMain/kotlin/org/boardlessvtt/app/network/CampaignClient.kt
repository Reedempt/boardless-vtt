package org.boardlessvtt.app.network

import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.boardlessvtt.app.util.IdGenerator

class CampaignClient(private val scope: CoroutineScope) {

    private val client = createPlatformHttpClient()
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

    suspend fun createCharacter(
        campaignId: String,
        ownerUserId: String,
        raceId: String,
        classId: String,
        backgroundId: String,
        name: String,
        str: Int, dex: Int, con: Int, intelligence: Int, wis: Int, cha: Int,
        backgroundAbilityChoices: Map<String, Int>,
        hitDie: Int
    ): ServerMessage = sendAndAwait(
        ClientMessage.CreateCharacter(
            requestId = IdGenerator.newId(),
            campaignId = campaignId, ownerUserId = ownerUserId,
            raceId = raceId, classId = classId, backgroundId = backgroundId, name = name,
            str = str, dex = dex, con = con, intelligence = intelligence, wis = wis, cha = cha,
            backgroundAbilityChoices = backgroundAbilityChoices, hitDie = hitDie
        )
    )

    suspend fun updateHp(characterId: String, newHp: Int): ServerMessage =
        sendAndAwait(ClientMessage.UpdateHp(IdGenerator.newId(), characterId, newHp))

    suspend fun close() {
        client.close()
    }
}