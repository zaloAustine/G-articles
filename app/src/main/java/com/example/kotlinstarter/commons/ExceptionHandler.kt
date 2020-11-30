package com.example.kotlinstarter.commons

import androidx.annotation.StringRes
import com.example.kotlinstarter.R
import java.net.UnknownHostException

internal object ExceptionHandler {
    fun parse(t: Throwable): String {
        return when (t) {
            is UnknownHostException -> R.string.error_check_internet_connection.toString()
            else -> R.string.error_oops_error_occured.toString()
        }
    }

}