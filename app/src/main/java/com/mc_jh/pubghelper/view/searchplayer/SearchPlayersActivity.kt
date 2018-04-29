package com.mc_jh.pubghelper.view.searchplayer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import android.widget.SimpleAdapter
import com.mc_jh.pubghelper.R
import com.mc_jh.pubghelper.data.Resource
import com.mc_jh.pubghelper.view.BaseActivity
import kotlinx.android.synthetic.main.activity_search_players.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

class SearchPlayersActivity : BaseActivity() {
    override val layoutRes: Int = R.layout.activity_search_players

    private lateinit var searchPlayersVM: SearchPlayersVM

    override fun setupViews() {
        searchButton.setOnClickListener {
            val position = spinner.selectedItemPosition
            val playerName = playerNameEditText.text.toString()
            searchPlayersVM.onSearch(position, playerName)
        }
        saveButton.setOnClickListener {
            searchPlayersVM.onSave()
        }
        searchPlayersVM = ViewModelProviders.of(this).get(SearchPlayersVM::class.java)
        subscribeUI(searchPlayersVM)
    }

    private fun subscribeUI(viewModel: SearchPlayersVM) {
        viewModel.eventAlert.observe(this, Observer {
            it?.let {
                alert(it) { okButton { } }.show()
            }
        })
        viewModel.region.observe(this, Observer {
            it?.let {
                val data = it.toList().map { mapOf("identifier" to it) }
                spinner.adapter = SimpleAdapter(this@SearchPlayersActivity, data, R.layout.support_simple_spinner_dropdown_item, arrayOf("identifier"), intArrayOf(android.R.id.text1))
            }
        })
        viewModel.searchPlayer.observe(this, Observer {
            when (it?.status) {
                Resource.Status.SUCCESS -> {
                    saveButton.visibility = View.VISIBLE
                    resultTextView.text = it.data?.toString()
                }
                Resource.Status.LOADING, Resource.Status.ERROR -> {
                    resultTextView.text = it.message
                    saveButton.visibility = View.GONE
                }
                null -> {
                }
            }
        })
        viewModel.eventSavePlayer.observe(this, Observer {
            if (it?.status?.isSuccess == true) {
                alert("플레이어를 저장했습니다.") { okButton { } }.show()
            }
        })
    }

}