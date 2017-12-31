package com.android.zhuyilin.fantuan

import org.litepal.LitePalApplication
import org.litepal.tablemanager.Connector

class MainApplication: LitePalApplication() {

    override fun onCreate() {
        super.onCreate()
        val database = Connector.getDatabase()
        println("database = ${database.version}")
    }
}