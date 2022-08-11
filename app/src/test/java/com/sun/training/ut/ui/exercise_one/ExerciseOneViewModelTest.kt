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

    private lateinit var vm: ExerciseOneViewModel

    @Before
    fun setup() {
        vm = ExerciseOneViewModel()
    }

    @Test
    fun `call bill with price null return empty`() {
        val price = null
        val result = vm.bill(price)
        val expected = ""
        assertEquals(expected, result)
    }

    @Test
    fun `call bill with price 0 return Free`() {
        val price = 0
        val result = vm.bill(price)
        val expected = "Free"
        assertEquals(expected, result)
    }

    @Test
    fun `call bill with price negative return Error`() {
        val price = -100
        val result = vm.bill(price)
        val expected = "Error"
        assertEquals(expected, result)
    }

    @Test
    fun `call bill with price positive return result`() {
        val price = 1
        val result = vm.bill(price)
        val expected = "Cái giá phải trả: ${price.formatNumberPrice()}"
        assertEquals(expected, result)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount 0 or negative , hour in 16 to 17, no voucher`() {
        val hour = 16
        val voucher = false
        val beers = 0
        val expected = 0
        vm.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, vm.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount 0 or negative`() {
        val hour = 16
        val voucher = true
        val beers = 0
        val expected = 0
        vm.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, vm.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount positive, hour in 16 to 17, no voucher`() {
        val hour = 16
        val voucher = false
        val beers = 2
        val expected = ExerciseOneViewModel.PRICE_AT_SALE_TIME * 2
        vm.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, vm.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount positive, hour in 16 to 17, have voucher`() {
        val hour = 16
        val voucher = true
        val beers = 2
        val expected =
            ExerciseOneViewModel.PRICE_WITH_VOUCHER + ExerciseOneViewModel.PRICE_AT_SALE_TIME
        vm.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, vm.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount positive, hour not in 16 to 17, no voucher`() {
        val hour = 20
        val voucher = false
        val beers = 2
        val expected = ExerciseOneViewModel.REGULAR_PRICE * 2
        vm.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, vm.total.value)
    }

    @Test
    fun `call calculatorTotalAmount with beersAmount positive, hour not in 16 to 17, have voucher`() {
        val hour = 20
        val voucher = true
        val beers = 2
        val expected = ExerciseOneViewModel.PRICE_WITH_VOUCHER + ExerciseOneViewModel.REGULAR_PRICE
        vm.calculatorTotalAmount(
            hour = hour,
            voucher = voucher,
            beersAmount = beers
        )
        assertEquals(expected, vm.total.value)
    }
}
