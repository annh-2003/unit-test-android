package com.sun.training.ut

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sun.training.ut.ui.exercise_five.ExerciseFiveViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExerciseFiveViewModelTest {
    private lateinit var viewModel: ExerciseFiveViewModel
    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instanceExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        viewModel = ExerciseFiveViewModel()
    }

    @Test
    fun calPrice_atStore_FreeSecondPizza(){
        viewModel.pricePizza.postValue(300)
        viewModel.numPizza.postValue(10)
        viewModel.atStore.postValue(true)
        assertEquals(viewModel.calPrice(),3000)
    }

    @Test
    fun calPrice_atStore1Pizza_Paid1Pizza(){
        viewModel.pricePizza.postValue(300)
        viewModel.numPizza.postValue(1)
        viewModel.atStore.postValue(true)
        assertEquals(viewModel.calPrice(),300)
    }

    @Test
    fun calPrice_atStoreHave0Pizza_Paid0(){
        viewModel.pricePizza.postValue(300)
        viewModel.numPizza.postValue(0)
        viewModel.atStore.postValue(true)
    }

    @Test
    fun calPrice_notAtStore_FixPrice(){
        viewModel.pricePizza.postValue(300)
        viewModel.numPizza.postValue(10)
        viewModel.atStore.postValue(false)
        assertEquals(viewModel.calPrice(),3000)
    }

    @Test
    fun disCountPrice_haveCoupon_Discount20(){
        viewModel.pricePizza.postValue(300)
        viewModel.numPizza.postValue(10)
        viewModel.haveCoupon.postValue(true)
        assertEquals(viewModel.calPrice(),2400)
    }

    @Test
    fun disCountPrice_haveCouponDiscount10_Discount10(){
        viewModel.pricePizza.postValue(300)
        viewModel.numPizza.postValue(10)
        viewModel.haveCoupon.postValue(true)
        assertEquals(viewModel.calPrice(0.9),2700)
    }

    @Test
    fun disCountPrice_notHaveCoupon_NoDiscount20(){
        viewModel.pricePizza.postValue(300)
        viewModel.numPizza.postValue(10)
        viewModel.haveCoupon.postValue(false)
        assertEquals(viewModel.calPrice(),3000)
    }

}