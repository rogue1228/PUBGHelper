package com.mc_jh.pubghelper.data.database.dao

import android.arch.persistence.room.*
import com.mc_jh.pubghelper.data.database.entity.PlayerEntity


@Dao
interface PlayerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayers(vararg players: PlayerEntity)

    @Update
    fun updatePlayers(vararg players: PlayerEntity)

    @Delete
    fun deletePlayers(vararg players: PlayerEntity)

    @Query("SELECT * FROM players")
    fun loadAllPlayers(): List<PlayerEntity>
}