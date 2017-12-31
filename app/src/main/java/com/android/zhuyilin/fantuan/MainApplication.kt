package com.android.zhuyilin.fantuan

import com.android.zhuyilin.fantuan.model.Subject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.litepal.LitePalApplication
import org.litepal.crud.DataSupport
import org.litepal.tablemanager.Connector

class MainApplication: LitePalApplication() {

    override fun onCreate() {
        if (DataSupport.count(Subject::class.java) == 0) {
            val jsonDataFile = assets.open("201710.json")
            val lenght = jsonDataFile.available()
            val buffer = ByteArray(lenght)
            jsonDataFile.read(buffer)
            val string = String(buffer)

            val subjects = Gson().fromJson<List<Subject>>(string, object : TypeToken<List<Subject>>() {}.type)
            DataSupport.saveAll(subjects)
            Connector.getDatabase()
        }
        super.onCreate()
    }
}