package com.mc_jh.pubghelper

import de.kevcodez.pubg.client.ApiClient
import de.kevcodez.pubg.client.PlayerFilter
import de.kevcodez.pubg.model.Region
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Test

class PubgApiTest {

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
        val playerResponse = apiClient.getPlayers(Region.PC_KOREA_JAPAN, PlayerFilter(playerNames = listOf("Sleeptime_GRT")))
        playerResponse.players.forEach {
            println(it.id)
        }
    }
}