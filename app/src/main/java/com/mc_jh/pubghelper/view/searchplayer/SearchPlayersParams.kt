package com.mc_jh.pubghelper.view.searchplayer

import de.kevcodez.pubg.model.Region

data class SearchPlayersParams(
        val region: Region,
        val playerName: String
)