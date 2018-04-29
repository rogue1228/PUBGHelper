package com.mc_jh.pubghelper.data.repository

import com.mc_jh.pubghelper.data.database.PUBGDatabase
import com.mc_jh.pubghelper.data.mapper.PlayerMapper
import com.mc_jh.pubghelper.model.PlayerModel
import de.kevcodez.pubg.client.ApiClient
import de.kevcodez.pubg.client.PlayerFilter
import de.kevcodez.pubg.model.Region
import de.kevcodez.pubg.model.player.PlayerResponse
import io.reactivex.Observable
import io.reactivex.Single

class PlayersRepository(private val pubgApiClient: ApiClient, private val database: PUBGDatabase) {
    fun searchPlayerByName(region: Region, playerName: String): Single<PlayerModel> {
        return getPlayers(region, PlayerFilter(emptyList(), listOf(playerName)))
                .map {
                    PlayerMapper.transform(it).first()
                }
                .singleOrError()
    }

    fun savePlayer(playerModel: PlayerModel): Single<PlayerModel> {
        return Observable.create<PlayerModel> {
            try {
                database.playerDAO().insertPlayers(PlayerMapper.modelToDBEntity(playerModel))
                it.onNext(playerModel)
                it.onComplete()
            } catch (e: Exception) {
                it.onError(e)
            }
        }.singleOrError()
    }

    private fun getPlayers(region: Region, playerFilter: PlayerFilter): Observable<PlayerResponse> {
        return Observable.create<PlayerResponse> {
            try {
                it.onNext(pubgApiClient.getPlayers(region, playerFilter))
                it.onComplete()
            } catch (e: Exception) {
                it.onError(e)
            }
        }
    }
}