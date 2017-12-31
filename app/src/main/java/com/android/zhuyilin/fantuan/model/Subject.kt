package com.android.zhuyilin.fantuan.model

import com.google.gson.annotations.SerializedName
import org.litepal.crud.DataSupport
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class Subject: Serializable, DataSupport() {
    lateinit var title: String
    @SerializedName("airtime_begin_at")lateinit var airtimeBeginAt: Date
    @SerializedName("poster_url")var posterUrl: String ?= null
    var tags: MutableList<String> = ArrayList()
    var description: String ?= null
    var followed: Boolean = false
    var wishList: Boolean = false
    var finished: Boolean = false
}
