package org.boardlessvtt.app.network

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.json.Json
import org.boardlessvtt.app.character.CharacterRepository
import org.boardlessvtt.app.character.AbilityScores
import org.boardlessvtt.app.character.toNetworkCharacter
import kotlin.time.Duration.Companion.seconds
import org.boardlessvtt.app.campaign.CampaignRepository

class CampaignServer(
    private val characterRepository: CharacterRepository,
    private val campaignRepository: CampaignRepository,
    private val port: Int = NetworkConfig.DEFAULT_PORT
) {
    private var server: EmbeddedServer<*, *>? = null
    private val json = Json { ignoreUnknownKeys = true }

    val connectedPlayers = MutableStateFlow<Set<String>>(emptySet())

    fun start() {
        server = createPlatformServer(port) {
            install(WebSockets) {
                pingPeriod = 15.seconds
                timeout = 30.seconds
            }
            routing {
                webSocket("/campaign") {
                    try {
                        for (frame in incoming) {
                            if (frame is Frame.Text) {
                                val text = frame.readText()
                                val message = json.decodeFromString<ClientMessage>(text)
                                handleMessage(message, this)
                            }
                        }
                    } catch (e: Exception) {
                        // connessione chiusa o errore — per ora ignoriamo, gestiremo la pulizia stato in seguito
                    }
                }
            }
        }.also { it.start(wait = false) }
    }

    private suspend fun handleMessage(message: ClientMessage, session: DefaultWebSocketServerSession) {
        val response: ServerMessage = when (message) {
            is ClientMessage.JoinCampaign -> {
                val campaign = campaignRepository.getCampaignByJoinCode(message.joinCode)
                if (campaign == null) {
                    ServerMessage.JoinRejected(message.requestId, "Codice campagna non valido")
                } else {
                    connectedPlayers.value = connectedPlayers.value + message.userId
                    ServerMessage.JoinAccepted(message.requestId, campaign.id, campaign.game_id)
                }
            }
            is ClientMessage.GetCharacters -> {
                val characters = characterRepository.getCharactersForCampaign(message.campaignId)
                ServerMessage.CharactersList(message.requestId, characters.map { it.toNetworkCharacter() })
            }
            is ClientMessage.CreateCharacter -> {
                val scores = AbilityScores(
                    str = message.str, dex = message.dex, con = message.con,
                    intelligence = message.intelligence, wis = message.wis, cha = message.cha
                )
                val characterId = characterRepository.createCharacterWithPointBuy(
                    campaignId = message.campaignId, ownerUserId = message.ownerUserId,
                    raceId = message.raceId, primaryClassId = message.classId, backgroundId = message.backgroundId,
                    name = message.name, baseScores = scores,
                    backgroundAbilityChoices = message.backgroundAbilityChoices.toList(), hitDie = message.hitDie
                )
                val created = characterRepository.getCharacterById(characterId)
                if (created != null) ServerMessage.CharacterUpdated(message.requestId, created.toNetworkCharacter())
                else ServerMessage.Error(message.requestId, "Personaggio creato ma non recuperabile")
            }
            is ClientMessage.UpdateHp -> {
                characterRepository.updatePlayerHp(message.characterId, message.newHp)
                val updated = characterRepository.getCharacterById(message.characterId)
                if (updated != null) ServerMessage.CharacterUpdated(message.requestId, updated.toNetworkCharacter())
                else ServerMessage.Error(message.requestId, "Personaggio non trovato dopo l'aggiornamento")
            }
        }
        session.send(Frame.Text(json.encodeToString(ServerMessage.serializer(), response)))
    }

    fun stop() {
        server?.stop(1000, 2000)
        server = null
    }
}