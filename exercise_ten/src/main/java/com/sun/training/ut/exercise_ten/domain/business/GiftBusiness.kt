package com.sun.training.ut.exercise_ten.domain.business

/**
 * Define some business models for the gift method
 * Depends the payment amount
 */
internal object GiftBusiness {
    /**
     * You will receive the gift after payment amount
     * equals 5,000.0 円
     * equals 10,000.0 円
     */
    val GIFT_ACCEPTED_WITH_PAYMENT_EQUALS = listOf(PaymentAmountPointBusiness.PAYMENT_10K, PaymentAmountPointBusiness.PAYMENT_5K)
}