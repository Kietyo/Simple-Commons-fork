package com.simplemobiletools.commons.utils

import android.util.Log

object KietLog {
    fun i(s: String, printStackTrace: Boolean = false) {
        if (printStackTrace) {
            val throwable = Throwable()
            Log.i("kiet", "$s\n${throwable.stackTraceToString()}")
        } else {
            Log.i("kiet", s)
        }
    }

    fun e(s: String, printStackTrace: Boolean = true) {
        if (printStackTrace) {
            val throwable = Throwable()
            Log.e("kiet", "$s\n${throwable.stackTraceToString()}")
        } else {
            Log.e("kiet", s)
        }
    }
}
