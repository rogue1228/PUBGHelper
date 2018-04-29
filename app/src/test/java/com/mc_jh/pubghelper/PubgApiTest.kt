package com.mc_jh.pubghelper

import de.kevcodez.pubg.client.ApiClient
import de.kevcodez.pubg.client.PlayerFilter
import de.kevcodez.pubg.model.Region
import de.kevcodez.pubg.model.player.PlayerResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Test
import org.slf4j.LoggerFactory

class PubgApiTest {
//    val logger = LoggerFactory.getLogger(PubgApiTest::class.java)
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    @Throws(Exception::class)
    fun getPlayerByName() {
        val httpClient = OkHttpClient.Builder()
                .apply {
                    if (BuildConfig.DEBUG) {
                        addInterceptor(
                                HttpLoggingInterceptor().apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }
                        )
                    }
                }
                .build()
        val apiClient = ApiClient(BuildConfig.API_KEY, httpClient = httpClient)
        val playerResponse: PlayerResponse
        try {
            playerResponse = apiClient.getPlayers(Region.PC_ASIA, PlayerFilter(playerNames = listOf("Sleeptime_GRT")))
        } catch (e: Exception) {
            System.out.println(e.toString())
        }
//        playerResponse.players.forEach {
//            println(it.id)
//        }
    }
}