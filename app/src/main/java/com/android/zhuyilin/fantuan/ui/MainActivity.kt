package com.android.zhuyilin.fantuan.ui

import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.android.zhuyilin.fantuan.R
import com.android.zhuyilin.fantuan.databinding.ActivityMainBinding
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val dateTime = DateTime()
        val dayOfWeek = dateTime.dayOfWeek
        val text = "${SimpleDateFormat("MM月dd日", Locale.CHINA).format(Date())} ${dayOfWeek(dayOfWeek)}"
        val currentDateText = dataBinding.currentDateText
        currentDateText.text = text

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                val statusBarHeight = resources.getDimensionPixelSize(resourceId)
                val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                layoutParams.setMargins(0, statusBarHeight, 0, 0)
                currentDateText.layoutParams = layoutParams
            }
        }

        val mainViewPager = dataBinding.mainViewPager
        mainViewPager.adapter = MainViewPagerAdapter(fragmentManager)

        mainViewPager.currentItem = dayOfWeek - 1
    }

    companion object {
        fun dayOfWeek(dayOfWeek: Int): String {
            val toCH = when (dayOfWeek) {
                1 -> "一"
                2 -> "二"
                3 -> "三"
                4 -> "四"
                5 -> "五"
                6 -> "六"
                7 -> "日"
                else -> { "" }
            }
            return "星期$toCH"
        }
    }
}
