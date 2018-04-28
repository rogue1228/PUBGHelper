package com.mc_jh.pubghelper.data.mapper

import com.mc_jh.pubghelper.data.database.entity.PlayerAttributeEntity
import com.mc_jh.pubghelper.data.database.entity.PlayerEntity
import com.mc_jh.pubghelper.model.PlayerAttributeModel
import com.mc_jh.pubghelper.model.PlayerModel
import de.kevcodez.pubg.model.player.PlayerAttributes
import de.kevcodez.pubg.model.player.PlayerResponse
import de.kevcodez.pubg.model.player.PlayerType
import org.joda.time.DateTime

object PlayerMapper {
    fun transform(playerResponse: PlayerResponse): List<PlayerModel> {
        if (playerResponse.players.isEmpty()) {
            return emptyList()
        }
        return playerResponse.players.map { apiToModel(it) }
    }

    fun apiToModel(playerType: PlayerType): PlayerModel {
        return PlayerModel(playerType.id, apiToModel(playerType.attributes))
    }

    private fun apiToModel(playerAttributes: PlayerAttributes): PlayerAttributeModel {
        return PlayerAttributeModel(
                playerAttributes.createdAt,
                playerAttributes.updatedAt,
                playerAttributes.name,
                playerAttributes.stats,
                playerAttributes.titleId,
                playerAttributes.shardId,
                playerAttributes.patchVersion)
    }

    private fun apiToEntity(playerAttribute: PlayerAttributes): PlayerAttributeEntity {
        val createdAt = DateTime.parse(playerAttribute.createdAt.toString())
        val updatedAt = DateTime.parse(playerAttribute.updatedAt.toString())
        return PlayerAttributeEntity(
                createdAt.millis,
                updatedAt.millis,
                playerAttribute.name,
                playerAttribute.stats,
                playerAttribute.titleId,
                playerAttribute.shardId,
                playerAttribute.patchVersion)
    }

    fun apiToDBEntity(player: PlayerType): PlayerEntity {
        return PlayerEntity(player.id, apiToEntity(player.attributes))
    }

    fun apiToDBEntity(players: List<PlayerType>): List<PlayerEntity> {
        return players.map { apiToDBEntity(it) }
    }

    fun modelToDBEntity(playerModel: PlayerModel): PlayerEntity {
        return PlayerEntity(playerModel.id, modelToDBEntity(playerModel.attribute))
    }

    private fun modelToDBEntity(playerAttributeModel: PlayerAttributeModel): PlayerAttributeEntity {
        val createdAt = DateTime.parse(playerAttributeModel.createdAt.toString())
        val updatedAt = DateTime.parse(playerAttributeModel.updatedAt.toString())
        return PlayerAttributeEntity(
                createdAt.millis,
                updatedAt.millis,
                playerAttributeModel.name,
                playerAttributeModel.stats,
                playerAttributeModel.titleId,
                playerAttributeModel.shardId,
                playerAttributeModel.patchVersion)
    }

}