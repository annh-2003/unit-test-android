package com.sun.training.ut.ui.exercise_two

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.ui.base.BaseViewModel
import java.text.SimpleDateFormat
import java.util.*

class ExerciseTwoViewModel : BaseViewModel() {
    var myCalendar: Calendar = GregorianCalendar.getInstance()

    var isVipMember = MutableLiveData(true)

    private val _date = MutableLiveData(dateFormat())
    val date: LiveData<String>
        get() = _date

    private val _time = MutableLiveData(timeFormat())
    val time: LiveData<String>
        get() = _time

    private val _paidAmount = MediatorLiveData<Int>().apply {
        value = 0
        addSource(isVipMember){
            value = getPaid()
        }
    }
    val paidAmount: LiveData<Int>
        get() = _paidAmount

    val _atSpecificTime = MutableLiveData(isFreePaidTime())
    val atSpecificTime: LiveData<Boolean>
        get() = _atSpecificTime

    fun isAtHoliday(): Boolean {
        val myFormat = "dd/MM"
        val dateFormat = SimpleDateFormat(myFormat)
        val currentDate = dateFormat.format(myCalendar.time)
        return !ALL_HOLIDAYS.none { it == currentDate }
    }

    fun isAtWeekend() = when (myCalendar.get(Calendar.DAY_OF_WEEK)) {
        Calendar.SATURDAY, Calendar.SUNDAY -> true
        else -> false
    }

    fun isFreePaidTime(): Boolean {
        val fromTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 8)
            set(Calendar.MINUTE, 45)
        }

        val toTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 17)
            set(Calendar.MINUTE, 59)
        }

        val currentTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, myCalendar.get(Calendar.HOUR_OF_DAY))
            set(Calendar.MINUTE, myCalendar.get(Calendar.MINUTE))
        }
        return !(currentTime.after(toTime) || currentTime.before(fromTime))
    }

    fun getPaid(): Int {
        return when (isVipMember.value) {
            true -> 0
            else -> {
                if (isAtWeekend() || isAtHoliday()) 110
                else {
                    if (atSpecificTime.value == true) 0 else 110
                }
            }
        }
    }

    fun dateFormat(): String {
        val myFormat = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat(myFormat)
        return dateFormat.format(myCalendar.time)
    }

    fun timeFormat() =
        "${myCalendar.get(Calendar.HOUR_OF_DAY)}:${myCalendar.get(Calendar.MINUTE)}"

    fun updateCalendar() {
        _date.value = dateFormat()
        _time.value = timeFormat()
        _atSpecificTime.value = isFreePaidTime()
        _paidAmount.value = getPaid()
    }

    companion object {
        val ALL_HOLIDAYS = arrayOf("01/01","30/04","01/05","01/06","02/09","20/11","25/12")
    }
}