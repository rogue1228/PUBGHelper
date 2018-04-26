package com.mc_jh.pubghelper.view.main

import com.mc_jh.pubghelper.R
import com.mc_jh.pubghelper.view.BaseActivity

class MainActivity : BaseActivity() {
    override fun getLayoutRes(): Int = R.layout.activity_main
    override fun isHomeAsUpEnabled(): Boolean {
        return false
    }
}
