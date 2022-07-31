package com.sun.training.ut.exercise_ten.domain.business

/**
 * Define the point when the payment
 * Accept for Gift
 * Accept for Discount percent
 */
internal object PaymentAmountPointBusiness {

    // Payment great than or equals 10K can receive the gift and discount percent
    const val PAYMENT_10K = 10000.0

    // Payment great than or equals 10K can receive the gift and discount percent
    const val PAYMENT_5K = 5000.0

    // Payment great than or equals 10K can receive the discount percent
    const val PAYMENT_3K = 3000.0
}