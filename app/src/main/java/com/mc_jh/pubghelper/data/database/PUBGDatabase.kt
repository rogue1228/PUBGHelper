package com.mc_jh.pubghelper.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.mc_jh.pubghelper.data.database.converter.Converters
import com.mc_jh.pubghelper.data.database.dao.PlayerDAO
import com.mc_jh.pubghelper.data.database.entity.PlayerEntity

@Database(entities = [PlayerEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class PUBGDatabase : RoomDatabase() {
    public abstract fun playerDAO(): PlayerDAO
}