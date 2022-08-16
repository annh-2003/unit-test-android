package com.sun.training.ut.exercise_ten.ui

import androidx.lifecycle.MutableLiveData
import com.example.exercise_ten.R
import com.sun.training.ut.exercise_ten.data.model.Invoice
import com.sun.training.ut.exercise_ten.data.model.MemberClassType
import com.sun.training.ut.exercise_ten.data.model.User
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.BLACK_CLASS_MIN_10K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.BLACK_CLASS_MIN_3K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.BLACK_CLASS_MIN_5K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.GOLD_CLASS_MIN_10K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.GOLD_CLASS_MIN_3K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.GOLD_CLASS_MIN_5K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.SILVER_CLASS_MIN_10K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.SILVER_CLASS_MIN_3K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.DiscountBusiness.SILVER_CLASS_MIN_5K_DISCOUNT_PERCENT
import com.sun.training.ut.exercise_ten.domain.business.GiftBusiness
import com.sun.training.ut.exercise_ten.domain.business.PaymentAmountPointBusiness.PAYMENT_10K
import com.sun.training.ut.exercise_ten.domain.business.PaymentAmountPointBusiness.PAYMENT_3K
import com.sun.training.ut.exercise_ten.domain.business.PaymentAmountPointBusiness.PAYMENT_5K
import com.sun.training.ut.exercise_ten.util.SingleLiveData
import com.sun.training.ut.ui.base.BaseViewModel


const val BLACK_CLASS = "Hạng Đen"
const val GOLD_CLASS = "Hạng Vàng"
const val SILVER_CLASS = "Hạng Bạc"
const val NAME_DEFAULT = "Tran Quang Loc"

class ExerciseTenViewModel : BaseViewModel() {

    val user = MutableLiveData<User>()
    val invoice = SingleLiveData<Invoice>()
    val subTotal = MutableLiveData<Double>()

    init {
        user.value = User(
            userId = 99,
            userName = NAME_DEFAULT,
            classType = MemberClassType.BLACK_CLASS
        )
    }

    fun setInvoice() {
        val subTotal = subTotal.value ?: 0.0
        subTotal.let {
            val discount = discountCalculate(it)
            invoice.value = Invoice(
                invoiceId = 0,
                subTotal = it,
                discount = discount.toInt(),
                giftAccepted = giftAccepted(it),
                total = it - discount
            )
        }
    }

    fun setClassType(type: String) {
        val classType = when (type) {
            SILVER_CLASS -> MemberClassType.SILVER_CLASS
            GOLD_CLASS -> MemberClassType.GOLD_CLASS
            BLACK_CLASS -> MemberClassType.BLACK_CLASS
            else -> MemberClassType.UNKNOWN_CLASS
        }
        user.value?.apply {
            this.classType = classType
        }
    }

    private fun discountCalculate(subTotal: Double): Double {
        return user.value?.let { user ->
            when {
                user.classType == MemberClassType.SILVER_CLASS && subTotal >= PAYMENT_10K -> subTotal * SILVER_CLASS_MIN_10K_DISCOUNT_PERCENT
                user.classType == MemberClassType.SILVER_CLASS && subTotal >= PAYMENT_5K -> subTotal * SILVER_CLASS_MIN_5K_DISCOUNT_PERCENT
                user.classType == MemberClassType.SILVER_CLASS && subTotal >= PAYMENT_3K -> subTotal * SILVER_CLASS_MIN_3K_DISCOUNT_PERCENT
                user.classType == MemberClassType.GOLD_CLASS && subTotal >= PAYMENT_10K -> subTotal * GOLD_CLASS_MIN_10K_DISCOUNT_PERCENT
                user.classType == MemberClassType.GOLD_CLASS && subTotal >= PAYMENT_5K -> subTotal * GOLD_CLASS_MIN_5K_DISCOUNT_PERCENT
                user.classType == MemberClassType.GOLD_CLASS && subTotal >= PAYMENT_3K -> subTotal * GOLD_CLASS_MIN_3K_DISCOUNT_PERCENT
                user.classType == MemberClassType.BLACK_CLASS && subTotal >= PAYMENT_10K -> subTotal * BLACK_CLASS_MIN_10K_DISCOUNT_PERCENT
                user.classType == MemberClassType.BLACK_CLASS && subTotal >= PAYMENT_5K -> subTotal * BLACK_CLASS_MIN_5K_DISCOUNT_PERCENT
                user.classType == MemberClassType.BLACK_CLASS && subTotal >= PAYMENT_3K -> subTotal * BLACK_CLASS_MIN_3K_DISCOUNT_PERCENT
                else -> subTotal * DiscountBusiness.UNKNOWN_CLASS_DISCOUNT_PERCENT
            }
        } ?: 0.0
    }

    private fun giftAccepted(subTotal: Double): Boolean = subTotal in GiftBusiness.GIFT_ACCEPTED_WITH_PAYMENT_EQUALS

}