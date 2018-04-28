package com.mc_jh.pubghelper.view.searchplayer

import android.app.Application
import android.arch.core.util.Function
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.mc_jh.pubghelper.data.Resource
import com.mc_jh.pubghelper.model.PlayerModel

class SearchPlayersVM(application: Application) : AndroidViewModel(application) {

    val searchPlayersParams: MutableLiveData<SearchPlayersParams> = MutableLiveData()
    val players: LiveData<Resource<List<PlayerModel>>>

    init {
        players = Transformations.map(searchPlayersParams, Function {
            TODO("NotImplementedError")
        })
    }
}