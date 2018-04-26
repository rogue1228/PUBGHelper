package com.mc_jh.pubghelper.application.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Created by Administrator on 2018-04-23.
 */
class DataParseForegroundService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        return START_STICKY
    }
}