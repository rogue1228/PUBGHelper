package com.mc_jh.pubghelper.data.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "players")
data class PlayerEntity(
        @PrimaryKey
        val id: String,
        val attributeEntity: PlayerAttributeEntity
)