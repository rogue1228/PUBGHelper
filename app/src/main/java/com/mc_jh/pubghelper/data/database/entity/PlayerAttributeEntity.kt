package com.mc_jh.pubghelper.data.database.entity

import org.joda.time.DateTime


data class PlayerAttributeEntity(
        val createdAt: Long,
        val updatedAt: Long,
        /** PlayerEntity name */
        val name: String,
        /** Stats particular to players */
        val stats: Any?,
        /** Identifies the studio and game */
        val titleId: String,
        /** Platform-region shard */
        val shardId: String,
        /** Version of the game */
        val patchVersion: String
)
