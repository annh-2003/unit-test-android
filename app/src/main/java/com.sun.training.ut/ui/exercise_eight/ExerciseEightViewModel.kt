package com.sun.training.ut.ui.exercise_eight

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.formatNumberPrice
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseEightViewModel : BaseViewModel() {
    val ticketFee = MutableLiveData<Int>(0)

    fun fee(price: Int?) =
        if (price == null) ""
        else if (price < 0) "Error"
        else if (price == 0) ""
        else "Fee ${price.formatNumberPrice()}"

    fun checkFee(
        dayOfWeek: String,
        female: Boolean,
        age: Int
    ) {
        if (!ExerciseEightActivity.dayOfWeeks.contains(dayOfWeek)) {
            ticketFee.value = -1
            return
        }
        if (age < MIN_AGE || age > MAX_AGE) {
            ticketFee.value = -1
            return
        }
        ticketFee.value = if (dayOfWeek == "Tuesday") TUESDAY_PRICE
        else if (age < CHILD_AGE) REGULAR_PRICE / 2
        else if (dayOfWeek == "Friday" && female) WOMAN_FRIDAY_PRICE
        else if (age > OLDER_AGE) OLDER_PRICE
        else REGULAR_PRICE
    }

    companion object {
        const val MAX_AGE = 120
        const val MIN_AGE = 0
        const val CHILD_AGE = 13
        const val OLDER_AGE = 65
        const val REGULAR_PRICE = 1800
        const val TUESDAY_PRICE = 1200
        const val OLDER_PRICE = 1600
        const val WOMAN_FRIDAY_PRICE = 1400
    }
}
