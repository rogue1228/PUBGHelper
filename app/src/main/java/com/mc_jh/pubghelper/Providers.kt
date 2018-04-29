package com.mc_jh.pubghelper

import android.app.Application
import android.arch.persistence.room.Room
import com.mc_jh.pubghelper.data.database.PUBGDatabase
import com.mc_jh.pubghelper.data.repository.PlayersRepository
import de.kevcodez.pubg.client.ApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class Providers(application: Application) {
    private val apiClient: ApiClient by lazy {
        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        }.build()
        ApiClient(BuildConfig.API_KEY, httpClient = httpClient)
    }
    private val database: PUBGDatabase by lazy {
        Room.databaseBuilder(application, PUBGDatabase::class.java, "_db").build()
    }
    val playersRepository: PlayersRepository by lazy { PlayersRepository(apiClient, database) }
}