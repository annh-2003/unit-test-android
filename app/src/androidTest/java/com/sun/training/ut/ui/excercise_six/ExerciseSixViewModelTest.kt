package com.sun.training.ut.ui.excercise_six

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExerciseSixViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private lateinit var viewModel: ExerciseSixViewModel

    @Before
    fun setupViewModel() {
        viewModel = ExerciseSixViewModel()
    }

    @Test
    fun purchased(){
        assertEquals(0, viewModel.purchased)
    }

    @Test
    fun parkingFreeTime_PurchasedNull_Zero(){
        viewModel.apply {
            purchased = null
            calculateParkingFreeTime()
        }
        assertEquals(0, viewModel.parkingFreeTime.value)
    }

    @Test
    fun parkingFreeTime_PurchasedLessThan2000_DontWatchMovie_Zero(){
        viewModel.apply {
            purchased = 1999
            calculateParkingFreeTime()
        }
        assertEquals(0, viewModel.parkingFreeTime.value)
    }

    @Test
    fun parkingFreeTime_PurchasedLessThan2000_WatchMovie_180(){
        viewModel.apply {
            purchased = 1999
            isWatchMovie = true
            calculateParkingFreeTime()
        }
        assertEquals(180, viewModel.parkingFreeTime.value)
    }

    @Test
    fun parkingFreeTime_PurchasedGreaterThan2000AndLessThan5000_DontWatchMovie_60(){
        viewModel.apply {
            purchased = 3000
            calculateParkingFreeTime()
        }
        assertEquals(60, viewModel.parkingFreeTime.value)
    }

    @Test
    fun parkingFreeTime_PurchasedGreaterThan2000AndLessThan5000_WatchMovie_240(){
        viewModel.apply {
            purchased = 3000
            isWatchMovie = true
            calculateParkingFreeTime()
        }
        assertEquals(240, viewModel.parkingFreeTime.value)
    }

    @Test
    fun parkingFreeTime_PurchasedGreaterThan5000_DontWatchMovie_120(){
        viewModel.apply {
            purchased = 5001
            calculateParkingFreeTime()
        }
        assertEquals(120 , viewModel.parkingFreeTime.value)
    }

    @Test
    fun parkingFreeTime_PurchasedGreaterThan5000_WatchMovie_300(){
        viewModel.apply {
            isWatchMovie = true
            purchased = 5001
            calculateParkingFreeTime()
        }
        assertEquals(300 , viewModel.parkingFreeTime.value)
    }
}