package com.mc_jh.pubghelper.model

import java.time.Instant

data class PlayerAttributeModel(
        val createdAt: Instant,
        val updatedAt: Instant,
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