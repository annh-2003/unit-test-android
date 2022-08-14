package com.sun.training.ut

import android.os.Build
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TimePicker
import java.text.DecimalFormat

fun Int.formatNumberPrice(): String {
    val formatter = DecimalFormat("#,###円")
    return formatter.format(this)
}

fun TimePicker.getHourWithBuildVersion() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) hour
    else currentHour

fun EditText.setNumberInputWithoutMultiZero(){
    filters = arrayOf(
        InputFilter { source, _, _, dest, _, _ ->
            if (dest.toString() == "0" && source.toString() == "0") {
                ""
            } else null
        }
    )
    val watcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (!s.isNullOrEmpty() && s.first() == '0'&& s.length>=2){
                removeTextChangedListener(this)
                val replacement = s.replaceFirst("^0+".toRegex(), "")
                setText(replacement)
                setSelection(replacement.length)
                addTextChangedListener(this)
            }
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }
    addTextChangedListener(watcher)
}
