package com.sun.training.ut

import android.os.Build
import android.widget.TimePicker
import java.text.DecimalFormat

fun Int.formatNumberPrice(): String {
    val formatter = DecimalFormat("#,###円")
    return formatter.format(this)
}

fun TimePicker.getHourWithBuildVersion() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) hour
    else currentHour
