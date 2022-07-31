package com.sun.training.ut.data.model

data class Beer(val isVoucher: Boolean, val isTimeCoupon: Boolean, val numberBeer: Int) :
    BaseModel()