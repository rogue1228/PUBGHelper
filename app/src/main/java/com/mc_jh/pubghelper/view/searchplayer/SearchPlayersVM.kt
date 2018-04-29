package com.mc_jh.pubghelper.view.searchplayer

import android.app.Application
import android.arch.core.util.Function
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.mc_jh.pubghelper.PUBGHelper
import com.mc_jh.pubghelper.SingleLiveEvent
import com.mc_jh.pubghelper.data.Resource
import com.mc_jh.pubghelper.data.repository.PlayersRepository
import com.mc_jh.pubghelper.model.PlayerModel
import de.kevcodez.pubg.exception.ApiException
import de.kevcodez.pubg.model.Region
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchPlayersVM(application: Application) : AndroidViewModel(application) {

    private val playersRepository: PlayersRepository = (application as PUBGHelper).providers.playersRepository
    val searchPlayersParams: MutableLiveData<SearchPlayersParams> = MutableLiveData()
    val searchPlayer: LiveData<Resource<PlayerModel>>
    val eventSavePlayer: SingleLiveEvent<Resource<PlayerModel>> = SingleLiveEvent()
    val region: MutableLiveData<Array<Region>> = MutableLiveData()
    val eventAlert: SingleLiveEvent<String> = SingleLiveEvent()

    init {
        searchPlayer = Transformations.switchMap(searchPlayersParams, Function {
            val mutableLiveData = MutableLiveData<Resource<PlayerModel>>()
            mutableLiveData.value = Resource.loading(null)
            playersRepository.searchPlayerByName(it.region, it.playerName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe { result, throwable ->
                        if (throwable != null) {
                            if (throwable is ApiException) {
                                mutableLiveData.value = Resource.error(throwable.toString(), null)
                            } else {
                                mutableLiveData.value = Resource.error(throwable.message, null)
                            }
                        } else {
                            mutableLiveData.value = Resource.success(result)
                        }
                    }
            return@Function mutableLiveData
        })
        region.value = Region.values()
    }

    fun setSearchPlayersParams(params: SearchPlayersParams) {
        if (searchPlayersParams.value == params && searchPlayer.value?.status != Resource.Status.ERROR) {
            return
        }
        searchPlayersParams.value = params
    }

    fun savePlayer(playerModel: PlayerModel) {
        eventSavePlayer.value = Resource.loading(null)
        playersRepository.savePlayer(playerModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe { result, throwable ->
                    if (throwable != null) {
                        eventSavePlayer.value = Resource.error(throwable.message, null)
                    } else {
                        eventSavePlayer.value = Resource.success(result)
                    }
                }
    }

    fun onSearch(position: Int, playerName: String) {
        val selectedRegion: Region
        try {
            selectedRegion = checkNotNull(region.value?.get(position)) { "지역을 선택해주세요." }
            check(playerName.isNotBlank()) { "플레이어 이름을 선택해주세요." }
            setSearchPlayersParams(SearchPlayersParams(selectedRegion, playerName))
        } catch (e: Exception) {
            eventAlert.value = e.message
        }
    }

    fun onSave() {
        try {
            val player = checkNotNull(searchPlayer.value?.data) { "저장할 플레이어가 없습니다." }
            savePlayer(player)
        } catch (e: Exception) {
            eventAlert.value = e.message
        }
    }
}