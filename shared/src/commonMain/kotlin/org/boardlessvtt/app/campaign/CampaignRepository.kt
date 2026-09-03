package org.boardlessvtt.app.campaign

import org.boardlessvtt.app.db.BoardlessDatabase
import org.boardlessvtt.app.util.IdGenerator
import org.boardlessvtt.app.util.currentTimeMillis

data class GameInfo(val id: String, val code: String, val name: String)
data class CampaignInfo(val id: String, val name: String, val gameId: String)

class CampaignRepository(private val database: BoardlessDatabase) {

    // Popola un gioco di test finché non esiste il vero flusso di download Rules Pack
    fun ensureSeedGames() {
        val existing = database.gamesQueries.selectAllGames().executeAsList()
        if (existing.isEmpty()) {
            database.gamesQueries.insertGame(
                IdGenerator.newId(),
                "dnd5e",
                "Dungeons & Dragons 5e (SRD)",
                null,
                null,
                0L,
                null,
                null
            )
        }
    }

    fun getAvailableGames(): List<GameInfo> {
        return database.gamesQueries.selectAllGames().executeAsList().map {
            GameInfo(id = it.id, code = it.code, name = it.name)
        }
    }

    fun createCampaign(name: String, gameId: String, dmUserId: String): String {
        val id = IdGenerator.newId()
        database.campaignsQueries.insertCampaign(id, gameId, dmUserId, name, currentTimeMillis())
        return id
    }

    fun getCampaignsForDm(dmUserId: String): List<CampaignInfo> {
        return database.campaignsQueries.selectCampaignsByDm(dmUserId).executeAsList().map {
            CampaignInfo(id = it.id, name = it.name, gameId = it.game_id)
        }
    }

    fun deleteCampaign(campaignId: String) {
        database.campaignsQueries.deleteCampaign(campaignId)
    }
}