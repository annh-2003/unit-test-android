package com.sun.training.ut.ui.exercise_one

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.formatNumberPrice
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseOneViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExerciseOneViewModel

    @Before
    fun setup() {
        viewModel = ExerciseOneViewModel()
    }

    @Test
    fun `call bill with payAmount null return empty`() {
        val payAmount = null
        val result = viewModel.bill(payAmount)
        val expected = ""
        assertEquals(expected, result)
    }

    @Test
    fun `call bill with payAmount 0 return Free`() {
        val payAmount = 0
        val result = viewModel.bill(payAmount)
        val expected = "Free"
        assertEquals(expected, result)
    }

    @Test
    fun `call bill with payAmount negative return Error`() {
        val payAmount = -100
        val result = viewModel.bill(payAmount)
        val expected = "Error"
        assertEquals(expected, result)
    }

    @Test
    fun `call bill with payAmount positive return result`() {
        val payAmount = 1
        val result = viewModel.bill(payAmount)
        val expected = "Cái giá phải trả: ${payAmount.formatNumberPrice()}"
        assertEquals(expected, result)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount 0 or negative , hour in 16 to 17, no voucher`() {
        val hour = 16
        val voucher = false
        val beers = 0
        val expected = 0
        viewModel.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, viewModel.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount 0 or negative`() {
        val hour = 16
        val voucher = true
        val beers = 0
        val expected = 0
        viewModel.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, viewModel.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount positive, hour in 16 to 17, no voucher`() {
        val hour = 16
        val voucher = false
        val beers = 2
        val expected = ExerciseOneViewModel.PRICE_AT_SALE_TIME * 2
        viewModel.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, viewModel.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount positive, hour in 16 to 17, have voucher`() {
        val hour = 16
        val voucher = true
        val beers = 2
        val expected =
            ExerciseOneViewModel.PRICE_WITH_VOUCHER + ExerciseOneViewModel.PRICE_AT_SALE_TIME
        viewModel.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, viewModel.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount positive, hour not in 16 to 17, no voucher`() {
        val hour = 20
        val voucher = false
        val beers = 2
        val expected = ExerciseOneViewModel.REGULAR_PRICE * 2
        viewModel.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, viewModel.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount positive, hour not in 16 to 17, have voucher`() {
        val hour = 20
        val voucher = true
        val beers = 2
        val expected = ExerciseOneViewModel.PRICE_WITH_VOUCHER + ExerciseOneViewModel.REGULAR_PRICE
        viewModel.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, viewModel.total.value)
    }
}
