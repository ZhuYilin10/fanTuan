package com.android.zhuyilin.fantuan.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.zhuyilin.fantuan.R
import com.android.zhuyilin.fantuan.databinding.ActivityMainBinding
import com.android.zhuyilin.fantuan.model.Subject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val subject = Subject()
        subject.title = "99999"
        val dataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        dataBinding.subject = subject
    }
}
