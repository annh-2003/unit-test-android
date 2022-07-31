package com.sun.training.ut.data.model

import com.sun.training.ut.data.Constant

data class Pizza(
    val bill: Int = 0,
    val typeDelivery: Constant.TypeDelivery = Constant.TypeDelivery.RECEIVE_AT_STORE,
    val isCoupon: Boolean = false
) : BaseModel()