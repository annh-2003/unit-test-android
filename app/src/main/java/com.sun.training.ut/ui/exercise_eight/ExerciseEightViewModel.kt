package com.sun.training.ut.ui.exercise_eight

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.data.Constant
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseEightViewModel : BaseViewModel() {
    private val builder: StringBuilder = java.lang.StringBuilder()

    val ageFormInput = MutableLiveData<Int>()
    val genderFromInput = MutableLiveData(Constant.Gender.MALE)
    val dayOfWeekFromInput = MutableLiveData(Constant.DayOfWeek.MONDAY)

    val item = MediatorLiveData<String>().apply {
        addSource(dayOfWeekFromInput) { input ->
            value = message(ageFormInput.value, genderFromInput.value!!, input)
        }
        addSource(ageFormInput) { input ->
            value = message(input, genderFromInput.value!!, dayOfWeekFromInput.value!!)
        }
        addSource(genderFromInput) { input ->
            value = message(ageFormInput.value, input, dayOfWeekFromInput.value!!)
        }
    }

    fun message(
        ageFormInput: Int?,
        gender: Constant.Gender,
        dayOfWeek: Constant.DayOfWeek
    ): String {
        builder.clear()
        if (!checkAgeNotNull(ageFormInput))
            return ""
        else if (!checkAgeValid(ageFormInput))
            return "Error"
        return "Tổng tiền : " + calculateTotalBill(ageFormInput, gender, dayOfWeek).toString()
    }

    fun calculateTotalBill(
        ageFormInput: Int?,
        gender: Constant.Gender,
        dayOfWeek: Constant.DayOfWeek
    ): Int {
        if (!checkAgeValid(ageFormInput))
            return -1
        return if (checkUsingServiceOnTuesday(dayOfWeek))
            1200
        else if (checkAgeSmallerThirteen(ageFormInput)) {
            900
        } else if (checkFemaleUsingServiceOnFriday(gender, dayOfWeek))
            1400
        else if (checkAgeBiggerSixtyFive(ageFormInput))
            1600
        else
            1800
    }

    private fun checkAgeValid(age: Int?): Boolean {
        return checkAgeNotNull(age) && age!! <= Constant.AGE_VALID_MAX && age >= Constant.AGE_VALID_MIN
    }

    private fun checkAgeNotNull(age: Int?) = age != null

    private fun checkAgeSmallerThirteen(age: Int?): Boolean {
        return checkAgeValid(age) && age!! < 13
    }

    private fun checkAgeBiggerSixtyFive(age: Int?): Boolean {
        return checkAgeValid(age) && age!! > 65
    }

    private fun checkFemaleUsingServiceOnFriday(
        gender: Constant.Gender,
        dayOfWeek: Constant.DayOfWeek
    ): Boolean {
        return gender == Constant.Gender.FEMALE && dayOfWeek == Constant.DayOfWeek.FRIDAY
    }

    private fun checkUsingServiceOnTuesday(dayOfWeek: Constant.DayOfWeek): Boolean {
        return dayOfWeek == Constant.DayOfWeek.TUESDAY
    }

}