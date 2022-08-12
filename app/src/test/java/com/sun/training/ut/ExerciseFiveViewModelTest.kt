package com.sun.training.ut

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.data.Constant
import com.sun.training.ut.ui.exercise_five.ExerciseFiveViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseFiveViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var vm: ExerciseFiveViewModel

    @Before
    fun setup() {
        vm = ExerciseFiveViewModel()
    }

    @Test
    fun `Check give potato promotion if total bill is less than 1500 result expect equal false`() {
        assertEquals(false, vm.givePotatoPromotion(1234))
    }

    @Test
    fun `Check give potato promotion if total bill is more than 1500 result expect equal true`() {
        assertEquals(true, vm.givePotatoPromotion(1501))
    }

    @Test
    fun `Check give potato promotion if total bill equal 1500 result expect equal false`() {
        assertEquals(false, vm.givePotatoPromotion(1500))
    }

    @Test
    fun `Check give Free Pizza Second if type delivery equal RECEIVE_AT_STORE result expect equal true`() {
        assertEquals(true, vm.giveFreePizzaSecond(Constant.TypeDelivery.RECEIVE_AT_STORE))
    }

    @Test
    fun `Check give Free Pizza Second if type delivery equal DELIVERY result expect equal false`() {
        assertEquals(false, vm.giveFreePizzaSecond(Constant.TypeDelivery.DELIVERY))
    }

    @Test
    fun `Check give coupon sale Off 20 Percent if Coupon equal OFF_20 result expect equal true`() {
        assertEquals(true, vm.giveCouponSaleOff20Percent(Constant.Coupon.OFF_20))
    }

    @Test
    fun `Check give coupon sale Off 20 Percent if Coupon equal REGULAR_FEE result expect equal false`() {
        assertEquals(false, vm.giveCouponSaleOff20Percent(Constant.Coupon.REGULAR_FEE))
    }

    @Test
    fun `Check CalculateTotalBill if we have not coupon OFF_20 result expect equal original total`() {
        val originalTotal = 1234
        val coupon = Constant.Coupon.REGULAR_FEE
        assertEquals(
            originalTotal,
            vm.calculateTotalBill(originalTotal, coupon)
        )
    }

    @Test
    fun `Check CalculateTotalBill if we have coupon OFF_20 result expect equal 80 percent of original total`() {
        val originalTotal = 1234
        val coupon = Constant.Coupon.OFF_20
        assertEquals(
            (originalTotal * 0.8).toInt(),
            vm.calculateTotalBill(originalTotal, coupon)
        )
    }

    @Test
    fun `Check message if total bill is more than 1500 and delivery and coupon equal regular fee`() {
        val totalFromInput = 1501
        val typeDelivery = Constant.TypeDelivery.DELIVERY
        val coupon = Constant.Coupon.REGULAR_FEE
        val builder = StringBuilder()
        builder.append("Bạn được khuyến mãi khoai tây chiên\n")
        builder.append("Bạn không được miễn phí pizza thứ 2\n")
        builder.append("Bạn không nhận được coupon\n")
        builder.append("Tổng tiền : 1501")
        assertEquals(
            builder.toString(),
            vm.billMessage(totalFromInput, typeDelivery, coupon)
        )
    }
}