package com.sun.training.ut.ui.exercise_eight

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.formatNumberPrice
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseEightViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var vm: ExerciseEightViewModel

    @Before
    fun setup() {
        vm = ExerciseEightViewModel()
    }

    @Test
    fun `call fee with price null return empty`() {
        val price = null
        val expected = ""
        val result = vm.fee(price)
        assertEquals(expected, result)
    }

    @Test
    fun `call fee with price 0 return empty`() {
        val price = null
        val expected = ""
        val result = vm.fee(price)
        assertEquals(expected, result)
    }

    @Test
    fun `call fee with price positive return Result`() {
        val price = 1000
        val expected = "Fee ${price.formatNumberPrice()}"
        val result = vm.fee(price)
        assertEquals(expected, result)
    }

    @Test
    fun `call fee with price negative return Error`() {
        val price = -1
        val expected = "Error"
        val result = vm.fee(price)
        assertEquals(expected, result)
    }

    @Test
    fun `call checkFee with day not correct`() {
        val day = ""
        val age = 10
        val female = false
        val expectTicketPrice = -1
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day correct, age not in 0 to 120`() {
        val day = "Monday"
        val age = 130
        val female = false
        val expectTicketPrice = -1
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day is Tuesday, age in 0 to 120`() {
        val day = "Tuesday"
        val age = 100
        val female = false
        val expectTicketPrice = ExerciseEightViewModel.TUESDAY_PRICE
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day not Tuesday, age in 0 to 12`() {
        val day = "Monday"
        val age = 10
        val female = false
        val expectTicketPrice = ExerciseEightViewModel.REGULAR_PRICE / 2
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day not Tuesday, age in 66 to 120, not woman`() {
        val day = "Monday"
        val age = 67
        val female = false
        val expectTicketPrice = ExerciseEightViewModel.OLDER_PRICE
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day is Friday, age in 66 to 120, is woman`() {
        val day = "Friday"
        val age = 67
        val female = true
        val expectTicketPrice = ExerciseEightViewModel.WOMAN_FRIDAY_PRICE
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day not Friday or Tuesday, age in 66 to 120, is woman`() {
        val day = "Monday"
        val age = 67
        val female = true
        val expectTicketPrice = ExerciseEightViewModel.OLDER_PRICE
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day not Tuesday, age in 13 to 65, not woman`() {
        val day = "Monday"
        val age = 65
        val female = false
        val expectTicketPrice = ExerciseEightViewModel.REGULAR_PRICE
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day is Friday, age in 13 to 65, is woman`() {
        val day = "Friday"
        val age = 65
        val female = true
        val expectTicketPrice = ExerciseEightViewModel.WOMAN_FRIDAY_PRICE
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }

    @Test
    fun `call checkFee with day not Friday or Tuesday, age in 13 to 65, is woman`() {
        val day = "Monday"
        val age = 65
        val female = true
        val expectTicketPrice = ExerciseEightViewModel.REGULAR_PRICE
        vm.checkFee(day, female, age)
        assertEquals(expectTicketPrice, vm.ticketFee.value)
    }
}
