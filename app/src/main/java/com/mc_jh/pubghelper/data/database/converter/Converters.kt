package com.mc_jh.pubghelper.data.database.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.mc_jh.pubghelper.data.database.entity.PlayerAttributeEntity
import org.joda.time.DateTime

class Converters {
    @TypeConverter
    fun fromTimestamp(timestamp: Long): DateTime {
        return DateTime(timestamp)
    }

    @TypeConverter
    fun dateTimeToTimestamp(dateTime: DateTime): Long {
        return dateTime.millis
    }

    @TypeConverter
    fun fromPlayerAttribute(json: String): PlayerAttributeEntity {
        return Gson().fromJson(json, PlayerAttributeEntity::class.java)
    }

    @TypeConverter
    fun playerAttributeToJson(playerAttributeEntity: PlayerAttributeEntity): String {
        return Gson().toJson(playerAttributeEntity)
    }
}