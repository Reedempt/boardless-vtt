package org.boardlessvtt.app.campaign

import org.boardlessvtt.app.db.BoardlessDatabase
import org.boardlessvtt.app.util.IdGenerator
import org.boardlessvtt.app.util.currentTimeMillis
import org.boardlessvtt.app.util.JoinCodeGenerator

data class GameInfo(val id: String, val code: String, val name: String)
data class CampaignInfo(val id: String, val name: String, val gameId: String, val joinCode: String)

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
        var joinCode: String
        do {
            joinCode = JoinCodeGenerator.generate()
        } while (database.campaignsQueries.selectCampaignByJoinCode(joinCode).executeAsOneOrNull() != null)

        database.campaignsQueries.insertCampaign(id, joinCode, gameId, dmUserId, name, currentTimeMillis())
        return id
    }

    fun getCampaignsForDm(dmUserId: String): List<CampaignInfo> =
        database.campaignsQueries.selectCampaignsByDm(dmUserId).executeAsList().map {
            CampaignInfo(id = it.id, name = it.name, gameId = it.game_id, joinCode = it.join_code)
        }

    fun getCampaignByJoinCode(joinCode: String) =
        database.campaignsQueries.selectCampaignByJoinCode(joinCode.uppercase()).executeAsOneOrNull()

    fun deleteCampaign(campaignId: String) {
        database.campaignsQueries.deleteCampaign(campaignId)
    }
}