package org.boardlessvtt.app.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class CampaignClient {

    private val client = HttpClient(CIO)

    suspend fun ping(hostIp: String, port: Int = NetworkConfig.DEFAULT_PORT): String {
        val response: HttpResponse = client.get("http://$hostIp:$port/ping")
        return response.bodyAsText()
    }

    fun close() {
        client.close()
    }
}