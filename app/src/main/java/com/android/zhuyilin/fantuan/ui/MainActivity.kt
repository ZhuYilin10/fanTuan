package com.android.zhuyilin.fantuan.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.zhuyilin.fantuan.R
import com.android.zhuyilin.fantuan.databinding.ActivityMainBinding
import com.android.zhuyilin.fantuan.model.Subject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.joda.time.DateTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val jsonDataFile = assets.open("201710.json")
        val lenght = jsonDataFile.available()
        val buffer = ByteArray(lenght)
        jsonDataFile.read(buffer)
        val string = String(buffer)

        val gson = Gson()
        val subjects = gson.fromJson<List<Subject>>(string, object : TypeToken<List<Subject>>() {}.type)

        val mainViewPager = dataBinding.mainViewPager
        mainViewPager.adapter = MainViewPagerAdapter(fragmentManager, subjects)

        val dateTime = DateTime()
        val dayOfWeek = dateTime.dayOfWeek
        
        mainViewPager.currentItem = dayOfWeek - 1

    }
}
