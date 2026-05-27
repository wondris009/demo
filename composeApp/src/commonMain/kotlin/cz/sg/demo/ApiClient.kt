package cz.sg.demo

import cz.sg.shared.model.MessageDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getMessages(): List<MessageDto> {
        val host = "http://${getPlatform().host}:8080" 
        return client.get("$host/api/1/messages/list").body()
    }
}
