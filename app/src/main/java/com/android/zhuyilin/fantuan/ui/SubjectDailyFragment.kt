package com.android.zhuyilin.fantuan.ui

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.zhuyilin.fantuan.R
import com.android.zhuyilin.fantuan.model.Subject
import com.android.zhuyilin.fantuan.ui.MainActivity.Companion.dayOfWeek
import org.joda.time.DateTime
import java.text.SimpleDateFormat
import java.util.*


class SubjectDailyFragment: Fragment() {
    var subjects: List<Subject> = ArrayList()
    var dayOfWeek = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_subject_daily, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = activity.findViewById(R.id.daily_recycle)
        val dayOfWeekTextView: TextView = activity.findViewById(R.id.week_of_day_text)

        val filter = subjects.filter {
            val airtimeBeginAt = DateTime(it.airtimeBeginAt)
            val dayOfWeek1 = airtimeBeginAt.dayOfWeek
            dayOfWeek == dayOfWeek1
        }
        dayOfWeekTextView.text = dayOfWeek(dayOfWeek)
        Collections.sort(filter, SortByAirTime())
        recyclerView.adapter = SubjectDailyRecycleAdapter(filter, activity)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    inner class SortByAirTime : Comparator<Subject> {
        override fun compare(w1: Subject, w2: Subject): Int {
            val v1 = SimpleDateFormat("HH:mm", Locale.CHINA).format(w1.airtimeBeginAt)
            val v2 = SimpleDateFormat("HH:mm", Locale.CHINA).format(w2.airtimeBeginAt)
            return v1.compareTo(v2)
        }
    }

    companion object {
        fun newInstance(subjects: List<Subject>, dayOfWeek: Int): Fragment {
            val subjectDailyFragment = SubjectDailyFragment()
            subjectDailyFragment.subjects = subjects
            subjectDailyFragment.dayOfWeek = dayOfWeek
            return subjectDailyFragment
        }
    }
}