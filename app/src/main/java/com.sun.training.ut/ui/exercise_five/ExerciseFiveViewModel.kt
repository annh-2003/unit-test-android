package com.sun.training.ut.ui.exercise_five

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.data.Constant
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseFiveViewModel : BaseViewModel() {

    private val builder: StringBuilder = java.lang.StringBuilder()

    val totalBillFormInput = MutableLiveData<Int>().apply { 0 }
    val typeDelivery = MutableLiveData<Constant.TypeDelivery>().apply {
        value = Constant.TypeDelivery.RECEIVE_AT_STORE
    }
    val isCoupon = MutableLiveData<Constant.Coupon>().apply { value = Constant.Coupon.REGULAR_FEE }
    val item = MediatorLiveData<String>().apply {
        addSource(totalBillFormInput) { input ->
            value = billMessage(input, typeDelivery.value!!, isCoupon.value!!)
        }
        addSource(typeDelivery) { input ->
            value = billMessage(totalBillFormInput.value ?: 0, input, isCoupon.value!!)
        }
        addSource(isCoupon) { input ->
            value = billMessage(totalBillFormInput.value ?: 0, typeDelivery.value!!, input)
        }
    }

    fun billMessage(
        totalFormInput: Int,
        type: Constant.TypeDelivery,
        coupon: Constant.Coupon
    ): String {
        builder.clear()
        if (totalFormInput <= 0)
            return ""
        if (givePotatoPromotion(totalFormInput)) {
            builder.appendIfNotAlreadyExist("Bạn được khuyến mãi khoai tây chiên\n")
        } else {
            builder.appendIfNotAlreadyExist("Bạn không được khuyến mãi khoai tây chiên\n")
        }
        if (giveFreePizzaSecond(type)) {
            builder.appendIfNotAlreadyExist("Bạn được miễn phí pizza thứ 2\n")
        } else {
            builder.appendIfNotAlreadyExist("Bạn không được miễn phí pizza thứ 2\n")
        }
        if (giveCouponSaleOff20Percent(coupon)) {
            builder.appendIfNotAlreadyExist("Bạn nhận được Coupon khuyến mãi 20%\n")
        } else {
            builder.appendIfNotAlreadyExist("Bạn không nhận được coupon\n")
        }
        return builder.appendIfNotAlreadyExist(
            "Tổng tiền : ${
                calculateTotalBill(
                    totalFormInput,
                    coupon
                )
            }"
        )
            .toString()
    }

    fun givePotatoPromotion(totalFormInput: Int): Boolean {
        return totalFormInput > Constant.DEFAULT_PRICE
    }

    fun giveFreePizzaSecond(type: Constant.TypeDelivery): Boolean {
        return type == Constant.TypeDelivery.RECEIVE_AT_STORE
    }

    fun giveCouponSaleOff20Percent(coupon: Constant.Coupon): Boolean {
        return coupon == Constant.Coupon.OFF_20
    }

    fun calculateTotalBill(
        totalFormInput: Int,
        coupon: Constant.Coupon
    ): Int {
        return if (giveCouponSaleOff20Percent(coupon)) {
            (totalFormInput * 0.8f).toInt()
        } else
            totalFormInput
    }

    private fun StringBuilder.appendIfNotAlreadyExist(value: String): StringBuilder {
        return if (this.contains(value))
            this
        else
            this.append(value)
    }
}