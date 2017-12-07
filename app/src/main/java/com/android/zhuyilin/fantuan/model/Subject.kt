package com.android.zhuyilin.fantuan.model

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList


class Subject: Serializable {
    lateinit var title: String
    lateinit var airtimeBeginAt: Date
    var posterUrl: String ?= null
    var tags: MutableList<String> = ArrayList()
    var description: String ?= null
}
