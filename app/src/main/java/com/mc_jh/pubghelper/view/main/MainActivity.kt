package com.mc_jh.pubghelper.view.main

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import com.mc_jh.pubghelper.R
import com.mc_jh.pubghelper.view.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val layoutRes: Int = R.layout.activity_main
    override val isHomeAsUpEnabled: Boolean = false


    private lateinit var mainVM: MainVM

    override fun setupViews() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            //replace fragment
            when (it.itemId) {
                R.id.feed -> {

                }
                R.id.history -> {

                }
                R.id.option -> {

                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        bottom_navigation.setOnNavigationItemReselectedListener {
            //scroll to top

        }
        mainVM = obtainVM(this)
        subscribeUI(mainVM)
    }

    private fun subscribeUI(vm: MainVM) {

    }

    companion object {
        fun obtainVM(activity: FragmentActivity): MainVM {
            return ViewModelProviders.of(activity).get(MainVM::class.java)
        }
    }
}
