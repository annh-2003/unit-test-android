package com.sun.training.ut.data.model

data class Customer(
    val hour: Int, val minute: Int, val isVip: Boolean, val dayOfMonth: Int, val monthOfYear: Int
) : BaseModel()