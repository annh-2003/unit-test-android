package com.sun.training.ut.exercise_ten

import android.widget.TimePicker
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import com.example.exercise_ten.R
import com.sun.training.ut.exercise_ten.data.model.MemberClassType

/**
 * @{AppBinding} Created by nguyen.van.bac on 06,October,2020
 */
object AppBinding {
    @BindingAdapter("selection")
    @JvmStatic
    fun setSelection(spinner: AppCompatSpinner, classType: Int) {
        val arrays = spinner.context.resources.getStringArray(R.array.member)
        val currentText = when (classType) {
            MemberClassType.BLACK_CLASS -> spinner.context.getString(R.string.ex_10_class_type_black)
            MemberClassType.GOLD_CLASS -> spinner.context.getString(R.string.ex_10_class_type_gold)
            MemberClassType.SILVER_CLASS -> spinner.context.getString(R.string.ex_10_class_type_silver)
            else -> null
        }
        val index = currentText?.let { arrays.indexOf(it) } ?: 0
        spinner.setSelection(index)
    }
}