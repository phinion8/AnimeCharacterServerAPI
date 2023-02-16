package com.example

import com.example.models.ApiResponse
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.http.*
import com.example.plugins.*
import com.example.repository.HeroRepository
import io.ktor.client.call.*
import io.ktor.util.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject

class ApplicationTest {
    private val heroRepository: HeroRepository by inject(HeroRepository::class.java)
    @Test
    fun `access root endpoint, assert correct information`() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Welcome to Boruto Api!", bodyAsText())
        }
    }
    @OptIn(InternalAPI::class)
    @Test
    fun `access all heroes endpoint, assert correct information`() = testApplication {
        application {
            configureRouting()
        }
        environment {
            developmentMode = false
        }
        client.get("/boruto/heroes?page=3").apply {
            assertEquals(expected = HttpStatusCode.OK, actual = status)
            val actual = Json.decodeFromString<ApiResponse>(this.body())
            val expected = ApiResponse(
                success = true,
                message = "OK",
                prevPage = 2,
                nextPage = 4,
                heroes = heroRepository.page3,
                lastUpdated = actual.lastUpdated

            )

            assertEquals(expected, actual)
        }
    }
}
