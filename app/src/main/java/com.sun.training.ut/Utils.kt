package com.sun.training.ut

import java.text.DecimalFormat

fun Int.formatNumberPrice(): String {
    val formatter = DecimalFormat("#,###円")
    return formatter.format(this)
}