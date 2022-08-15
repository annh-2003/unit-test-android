package com.sun.training.ut.ui.exercise_seven

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseSevenViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    lateinit var viewModel : ExerciseSevenViewModel

    @Before
    fun setUp() {
        viewModel = ExerciseSevenViewModel()
    }

    @Test
    fun `test Handle Monnet product OnSuccess`() {
        assertTrue(viewModel.handleMonneyProduct(5000))
    }

    @Test
    fun `test Handle Monnet product OnFail`() {
        assertFalse(viewModel.handleMonneyProduct(1000))
    }

    @Test
    fun `test Handle Transport Fee - onSuccess`() {
        val actual = viewModel.handleTransportFee(false , false , false)
        assertEquals( 500, actual)
    }

    @Test
    fun `test Handle Transport Fee - monney product 5000 - onSuccess`() {
        val actual = viewModel.handleTransportFee(true , false , false)
        assertEquals( 0, actual)
    }

    @Test
    fun `test Handle Transport Fee - Premium - onSuccess`() {
        val actual = viewModel.handleTransportFee(false , true , false)
        assertEquals( 0, actual)
    }

    @Test
    fun `test Handle Transport Fee - Super Speed - onSuccess`() {
        val actual = viewModel.handleTransportFee(false , false , true)
        assertEquals( 1000, actual)
    }

    @Test
    fun `test Handle Transport Fee - monney product greater 5000 and Premium - onSuccess`() {
        val actual = viewModel.handleTransportFee(true , true , false)
        assertEquals( 0, actual)
    }

    @Test
    fun `test Handle Transport Fee - monney product greater 5000 and Premium and Super Speed - onSuccess`() {
        val actual = viewModel.handleTransportFee(true , true , true)
        assertEquals( 500, actual)
    }
}
