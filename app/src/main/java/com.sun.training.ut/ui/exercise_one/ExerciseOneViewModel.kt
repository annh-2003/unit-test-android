package com.sun.training.ut.ui.exercise_one

import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.formatNumberPrice
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseOneViewModel : BaseViewModel() {

    val total = MutableLiveData<Int>()

    fun bill(payAmount: Int?) =
        if (payAmount == null) ""
        else if (payAmount < 0) "Error"
        else if (payAmount == 0) "Free"
        else "Cái giá phải trả: ${payAmount.formatNumberPrice()}"

    fun calculatorTotalAmount(
        hour: Int,
        voucher: Boolean,
        beersAmount: Int
    ) {
        if (beersAmount <= 0) {
            total.value = 0
            return
        }
        var price = REGULAR_PRICE
        if (hour in 16..17) price = PRICE_AT_SALE_TIME
        total.value = if (voucher) {
            (beersAmount - 1) * price + PRICE_WITH_VOUCHER
        } else {
            beersAmount * price
        }
    }

    companion object {
        const val REGULAR_PRICE = 490
        const val PRICE_AT_SALE_TIME = 290
        const val PRICE_WITH_VOUCHER = 100
    }
}
