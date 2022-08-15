package com.sun.training.ut.ui.exercise_four


import android.text.format.DateFormat
import android.util.Log
import android.widget.DatePicker
import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.ui.base.BaseViewModel
import java.util.*


class ExerciseFourViewModel : BaseViewModel() {
    val day = MutableLiveData("Day: ")
    val color = MutableLiveData<RuleColor>()

    fun dayChosen(datePicker: DatePicker){
        val dayConvertToMilliSeconds = getDateFromDatePicker(datePicker)
        day.value = "Day: ${convertDate(dayConvertToMilliSeconds)}"
        Log.d("zzz", day.value.toString())
        rule(convertDate(dayConvertToMilliSeconds))
    }

    private fun convertDate(dateInMilliseconds: Long): String{
        return DateFormat.format("E, dd MMM yyyy", dateInMilliseconds).toString()
    }

    private fun getDateFromDatePicker(datePicker: DatePicker): Long{
        val day = datePicker.dayOfMonth
        val month = datePicker.month
        val year = datePicker.year

        val calendar = Calendar.getInstance()
        calendar[year, month] = day

        return calendar.timeInMillis
    }

    fun rule(day: String){
        //holiday -> red
        //sunday -> red
        //saturday -> green (if not holiday)
        //normal day if not holiday -> black

        val listHoliday = arrayListOf("Sat, 13 Aug 2022")

        for (i in 0 until listHoliday.size){
            if (day == listHoliday[i] || day.contains("Sun")) color.value = RuleColor.RED
            else if (day.contains("Sat") && day!= listHoliday[i]) color.value = RuleColor.GREEN
            else if ((!day.contains("Sat") && !day.contains("Sun")) && day != listHoliday[i]){
                color.value = RuleColor.BLACK
            }
        }
    }
}

enum class RuleColor{
    RED, GREEN, BLACK
}