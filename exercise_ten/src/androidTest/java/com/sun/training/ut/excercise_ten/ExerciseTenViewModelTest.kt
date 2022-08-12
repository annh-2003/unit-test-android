package com.sun.training.ut.excercise_ten

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sun.training.ut.exercise_ten.ui.BLACK_CLASS
import com.sun.training.ut.exercise_ten.ui.ExerciseTenViewModel
import com.sun.training.ut.exercise_ten.ui.GOLD_CLASS
import com.sun.training.ut.exercise_ten.ui.SILVER_CLASS
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class ExerciseTenViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private lateinit var viewModel: ExerciseTenViewModel

    @Before
    fun setupViewModel() {
        viewModel = ExerciseTenViewModel()
    }

    // Sliver
    @Test
    fun discount_SilverAndSubtotalLessThan3000_Discount0Percent() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 2000.0
            setInvoice()
        }

        assertEquals(0, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_SilverAndSubtotalIs3000_Discount1Percent() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 3000.0
            setInvoice()
        }

        assertEquals(1, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_SilverAndSubtotalMoreThan3000AndLessThan5000_Discount1Percent() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 4000.0
            setInvoice()
        }

        assertEquals(1, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_SilverAndSubtotalIs5000_Discount2Percent() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 5000.0
            setInvoice()
        }

        assertEquals(2, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_SilverAndSubtotalMoreThan5000AndLessThan10000_Discount2Percent() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 6000.0
            setInvoice()
        }

        assertEquals(2, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_SilverAndSubtotalIs10000_Discount4Percent() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 10000.0
            setInvoice()
        }

        assertEquals(4, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_SilverAndSubtotalMoreThan10000_Discount4Percent() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 11000.0
            setInvoice()
        }

        assertEquals(4, viewModel.invoice.value?.discount)
    }

    @Test
    fun giftAccepted_SilverAndSubtotalLessThan5000_ReturnFalse() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 3000.0
            setInvoice()
        }

        assertEquals(false, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_SilverAndSubtotalIs5000_ReturnTrue() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 5000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_SilverAndSubtotalMoreThan5000AndLessThan10000_ReturnTrue() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 7000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_SilverAndSubtotalIs10000_ReturnTrue() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 10000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_SilverAndSubtotalMoreThan10000_ReturnFalse() {
        viewModel.apply {
            setClassType(SILVER_CLASS)
            subTotal.value = 11000.0
            setInvoice()
        }

        assertEquals(false, viewModel.invoice.value?.giftAccepted)
    }

    // Gold
    @Test
    fun discount_GoldAndSubtotalLessThan3000_Discount0Percent() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 2000.0
            setInvoice()
        }

        assertEquals(0, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_GoldAndSubtotalIs3000_Discount3Percent() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 3000.0
            setInvoice()
        }

        assertEquals(3, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_GoldAndSubtotalMoreThan3000AndLessThan5000_Discount3Percent() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 4000.0
            setInvoice()
        }

        assertEquals(3, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_GoldAndSubtotalIs5000_Discount5Percent() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 5000.0
            setInvoice()
        }

        assertEquals(5, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_GoldAndSubtotalMoreThan5000AndLessThan10000_Discount5Percent() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 6000.0
            setInvoice()
        }

        assertEquals(5, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_GoldAndSubtotalIs10000_Discount10Percent() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 10000.0
            setInvoice()
        }

        assertEquals(10, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_GoldAndSubtotalMoreThan10000_Discount10Percent() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 11000.0
            setInvoice()
        }

        assertEquals(10, viewModel.invoice.value?.discount)
    }

    @Test
    fun giftAccepted_GoldAndSubtotalLessThan5000_ReturnFalse() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 3000.0
            setInvoice()
        }

        assertEquals(false, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_GoldAndSubtotalIs5000_ReturnTrue() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 5000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_GoldAndSubtotalMoreThan5000AndLessThan10000_ReturnTrue() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 7000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_GoldAndSubtotalIs10000_ReturnTrue() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 10000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_GoldAndSubtotalMoreThan10000_ReturnFalse() {
        viewModel.apply {
            setClassType(GOLD_CLASS)
            subTotal.value = 11000.0
            setInvoice()
        }

        assertEquals(false, viewModel.invoice.value?.giftAccepted)
    }

    // Black

    @Test
    fun discount_BlackAndSubtotalLessThan3000_Discount0Percent() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 2000.0
            setInvoice()
        }

        assertEquals(0, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_BlackAndSubtotalIs3000_Discount5Percent() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 3000.0
            setInvoice()
        }

        assertEquals(5, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_BlackAndSubtotalMoreThan3000AndLessThan5000_Discount5Percent() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 4000.0
            setInvoice()
        }

        assertEquals(5, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_BlackAndSubtotalIs5000_Discount7Percent() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 5000.0
            setInvoice()
        }

        assertEquals(7, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_BlackAndSubtotalMoreThan5000AndLessThan10000_Discount7Percent() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 6000.0
            setInvoice()
        }

        assertEquals(7, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_BlackAndSubtotalIs10000_Discount15Percent() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 10000.0
            setInvoice()
        }

        assertEquals(15, viewModel.invoice.value?.discount)
    }

    @Test
    fun discount_BlackAndSubtotalMoreThan10000_Discount15Percent() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 11000.0
            setInvoice()
        }

        assertEquals(15, viewModel.invoice.value?.discount)
    }

    @Test
    fun giftAccepted_BlackAndSubtotalLessThan5000_ReturnFalse() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 3000.0
            setInvoice()
        }

        assertEquals(false, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_BlackAndSubtotalIs5000_ReturnTrue() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 5000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_BlackAndSubtotalMoreThan5000AndLessThan10000_ReturnTrue() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 7000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_BlackAndSubtotalIs10000_ReturnTrue() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 10000.0
            setInvoice()
        }

        assertEquals(true, viewModel.invoice.value?.giftAccepted)
    }

    @Test
    fun giftAccepted_BlackAndSubtotalMoreThan10000_ReturnFalse() {
        viewModel.apply {
            setClassType(BLACK_CLASS)
            subTotal.value = 11000.0
            setInvoice()
        }

        assertEquals(false, viewModel.invoice.value?.giftAccepted)
    }

}