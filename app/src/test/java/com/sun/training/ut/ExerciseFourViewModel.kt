package com.sun.training.ut

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.ui.exercise_four.ExerciseFourViewModel
import com.sun.training.ut.ui.exercise_four.RuleColor
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseFourViewModel {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExerciseFourViewModel

    @Before
    fun setup(){
        viewModel = ExerciseFourViewModel()
    }

    @Test
    fun `testDayChosen with holiday success`(){
        val day = "Mon, 01 Aug 2022"
        viewModel.rule(day)
        assertEquals(RuleColor.RED, viewModel.color.value)
    }

    @Test
    fun `testDayChosen with holiday on Saturday success`(){
        val day = "Sat, 13 Aug 2022"
        viewModel.rule(day)
        assertEquals(RuleColor.RED, viewModel.color.value)
    }

    @Test
    fun `testDayChosen with saturday success`(){
        val day = "Sat, 06 Aug 2022"
        viewModel.rule(day)
        assertEquals(RuleColor.GREEN, viewModel.color.value)
    }

    @Test
    fun `testDayChosen with sunday success`(){
        val day = "Sun, 07 Aug 2022"
        viewModel.rule(day)
        assertEquals(RuleColor.RED, viewModel.color.value)
    }

    @Test
    fun `testDayChosen with normal day success`(){
        val day = "Wed, 10 Aug 2022"
        viewModel.rule(day)
        assertEquals(RuleColor.BLACK, viewModel.color.value)
    }
}