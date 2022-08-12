package com.sun.training.ut

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sun.training.ut.ui.exercise_two.ExerciseTwoViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class ExerciseTwoViewModelTest {
    private lateinit var viewModel: ExerciseTwoViewModel
    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instanceExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        viewModel = ExerciseTwoViewModel()
    }

    @Test
    fun isFreePaidTime_Before8h45_False() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 8)
            set(Calendar.MINUTE, 20)
        }

        assertEquals(viewModel.isFreePaidTime(), false)
    }

    @Test
    fun isFreePaidTime_After17h59_False() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 19)
            set(Calendar.MINUTE, 59)
        }
        assertEquals(viewModel.isFreePaidTime(), false)
    }

    @Test
    fun isFreePaidTime_Between8h45And17h59_True() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 9)
            set(Calendar.MINUTE, 0)
        }
        assertEquals(viewModel.isFreePaidTime(), true)

    }

    @Test
    fun getPaid_vipMember_return0() {
        viewModel.isVipMember.postValue(true)
        assertEquals(viewModel.getPaid(), 0)
    }

    @Test
    fun getPaid_notVipMemberAtWeekend_return110() {
        viewModel.isVipMember.postValue(false)
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
        }
        assertEquals(viewModel.getPaid(), 110)
    }

    @Test
    fun getPaid_notVipMemberAndNotAtWeekendAndBetween8h45And17h59_return0() {
        viewModel.isVipMember.postValue(false)
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 9)
            set(Calendar.MINUTE, 0)
            set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
        }
        viewModel.updateCalendar()
        assertEquals(viewModel.isVipMember.value, false)
        assertEquals(viewModel.isAtWeekend(), false)
        assertEquals(viewModel.isFreePaidTime(), true)
        assertEquals(viewModel.getPaid(), 0)
    }

    @Test
    fun getPaid_notVipMemberAndNotAtWeekendAndNotBetween8h45And17h59_return110() {
        viewModel.isVipMember.postValue(false)
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 7)
            set(Calendar.MINUTE, 0)
            set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
        }
        viewModel.updateCalendar()
        assertEquals(viewModel.getPaid(), 110)
    }

    @Test
    fun dateFormat_returnDateWithRightFormat() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_MONTH, 11)
            set(Calendar.YEAR, 2022)
            set(Calendar.MONTH, Calendar.AUGUST)
        }
        assertEquals(viewModel.dateFormat(), "11/08/2022")
    }

    @Test
    fun timeFormat_returnTimeWithRightFormat() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 9)
            set(Calendar.MINUTE, 0)
        }
        assertEquals(viewModel.timeFormat(), "9:0")
    }

    @Test
    fun isAtWeekend_AtWeekend_True() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
        }
        assertEquals(viewModel.isAtWeekend(), true)
    }

    @Test
    fun isAtWeekend_notAtWeekend_False() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
        }
        assertEquals(viewModel.isAtWeekend(), false)

    }

    @Test
    fun isAtHoliday_atHoliday_True() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_MONTH, 2)
            set(Calendar.MONTH, Calendar.SEPTEMBER)
        }
        assertEquals(viewModel.isAtHoliday(), true)
    }

    @Test
    fun isAtHoliday_notAtHoliday_False() {
        viewModel.myCalendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_MONTH, 2)
            set(Calendar.MONTH, Calendar.JULY)
        }
        assertEquals(viewModel.isAtHoliday(), false)
    }
}