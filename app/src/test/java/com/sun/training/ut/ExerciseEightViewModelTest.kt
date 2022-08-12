package com.sun.training.ut

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.data.Constant
import com.sun.training.ut.ui.exercise_eight.ExerciseEightViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseEightViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var vm: ExerciseEightViewModel

    @Before
    fun setup() {
        vm = ExerciseEightViewModel()
    }

    @Test
    fun `check total bill if normal`(){
        val result = 1800
        assertEquals(result, vm.calculateTotalBill(23,Constant.Gender.MALE,Constant.DayOfWeek.MONDAY))
    }

    @Test
    fun `check total bill if age is less than 13`(){
        val result = 900
        assertEquals(result, vm.calculateTotalBill(12,Constant.Gender.MALE,Constant.DayOfWeek.MONDAY))
    }

    @Test
    fun `check total bill if age is more than 65`(){
        val result = 1600
        assertEquals(result, vm.calculateTotalBill(66,Constant.Gender.MALE,Constant.DayOfWeek.MONDAY))
    }

    @Test
    fun `check total bill if gender is female and using service on friday`(){
        val result = 1400
        assertEquals(result, vm.calculateTotalBill(66,Constant.Gender.FEMALE,Constant.DayOfWeek.FRIDAY))
    }

    @Test
    fun `check total bill if using service on tuesday`(){
        val result = 1200
        assertEquals(result, vm.calculateTotalBill(23,Constant.Gender.FEMALE,Constant.DayOfWeek.TUESDAY))
    }

    @Test
    fun `check total bill if using service on tuesday and age is less than 13`(){
        val result = 1200
        assertEquals(result, vm.calculateTotalBill(12,Constant.Gender.FEMALE,Constant.DayOfWeek.TUESDAY))
    }

    @Test
    fun `check total bill if using service on tuesday and age is more than 65`(){
        val result = 1200
        assertEquals(result, vm.calculateTotalBill(66,Constant.Gender.FEMALE,Constant.DayOfWeek.TUESDAY))
    }

    @Test
    fun `check total bill if not using service on tuesday and friday and age is less than 13`(){
        val result = 900
        assertEquals(result, vm.calculateTotalBill(12,Constant.Gender.FEMALE,Constant.DayOfWeek.MONDAY))
    }


    @Test
    fun `check invalid age is less than 0`(){
        assertEquals("Error", vm.message(-1,Constant.Gender.FEMALE,Constant.DayOfWeek.TUESDAY))
    }

    @Test
    fun `check invalid if age is more than 120`(){
        assertEquals("Error", vm.message(121,Constant.Gender.FEMALE,Constant.DayOfWeek.TUESDAY))
    }


    @Test
    fun `check total bill if using service on tuesday and age equal 13`(){
        assertEquals(1400, vm.calculateTotalBill(13,Constant.Gender.FEMALE,Constant.DayOfWeek.FRIDAY))
    }

}