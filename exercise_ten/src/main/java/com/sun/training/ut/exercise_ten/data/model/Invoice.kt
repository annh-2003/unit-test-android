package com.sun.training.ut.exercise_ten.data.model

data class Invoice(
    val invoiceId: Int,
    var subTotal: Double,
    var discount: Double = 0.0,
    var giftAccepted: Boolean = false,
    var total: Double,
)