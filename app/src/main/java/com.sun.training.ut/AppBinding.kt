package com.sun.training.ut

import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.sun.training.ut.data.model.No9Result
import java.text.DecimalFormat

/**
 * @{AppBinding}
 * Created by nguyen.van.bac on 15,September,2020
 */

object AppBinding {
    @BindingAdapter("price")
    @JvmStatic
    fun price(tv: TextView, price: Int) {
        tv.text = price.formatNumberPrice()
    }

    @BindingAdapter("is24Hour")
    @JvmStatic
    fun is24Hour(timePicker: TimePicker, is24Hour: Boolean) {
        timePicker.setIs24HourView(is24Hour)
    }

    @BindingAdapter("result")
    @JvmStatic
    fun setNo9Result(tv: AppCompatTextView, result: No9Result?) {
        result?.apply {
            when {
                findRoom -> {
                    tv.setText(R.string.can_not_find_room)
                }
                inputRoom != true -> {
                    tv.setText(R.string.can_not_go_room)
                }
                beatBoss != true -> {
                    tv.setText(R.string.can_not_beat_boss)
                }
                else -> {
                    tv.setText(R.string.beat_boss)
                }
            }
        }
    }
}