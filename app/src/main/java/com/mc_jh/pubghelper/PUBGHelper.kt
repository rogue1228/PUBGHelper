package com.mc_jh.pubghelper

import android.app.Application
import net.danlew.android.joda.JodaTimeAndroid

class PUBGHelper : Application() {

    val providers: Providers by lazy { Providers(this) }

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
    }

}