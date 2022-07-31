package com.sun.training.ut.data.model

import com.sun.training.ut.data.Constant

data class No8Member(var age: Int = 0,
                     var gender: Constant.Gender = Constant.Gender.MALE) : BaseModel()