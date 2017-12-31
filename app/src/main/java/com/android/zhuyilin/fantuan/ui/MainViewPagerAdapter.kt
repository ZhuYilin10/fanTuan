package com.android.zhuyilin.fantuan.ui

import android.app.Fragment
import android.app.FragmentManager
import android.support.v13.app.FragmentStatePagerAdapter
import com.android.zhuyilin.fantuan.model.Subject

class MainViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        val dayOfWeek: Int = position + 1
        return SubjectDailyFragment.newInstance(dayOfWeek)
    }

    override fun getCount(): Int {
        return 7
    }
}
