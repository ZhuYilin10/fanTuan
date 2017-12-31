package com.android.zhuyilin.fantuan

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.zhuyilin.fantuan.model.Subject
import com.android.zhuyilin.fantuan.ui.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.litepal.crud.DataSupport
import org.litepal.tablemanager.Connector

class LaunchActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        startActivity(intentFor<MainActivity>().newTask().addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT))
        finish()
    }
}
