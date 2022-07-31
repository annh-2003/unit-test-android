package com.sun.training.ut.exercise_ten.data.model

import androidx.annotation.IntDef
import com.sun.training.ut.exercise_ten.data.model.MemberClassType.Companion.BLACK_CLASS
import com.sun.training.ut.exercise_ten.data.model.MemberClassType.Companion.GOLD_CLASS
import com.sun.training.ut.exercise_ten.data.model.MemberClassType.Companion.SILVER_CLASS
import com.sun.training.ut.exercise_ten.data.model.MemberClassType.Companion.UNKNOWN_CLASS

@IntDef(SILVER_CLASS, GOLD_CLASS, BLACK_CLASS, UNKNOWN_CLASS)
annotation class MemberClassType {
    companion object {
        const val SILVER_CLASS = 1
        const val GOLD_CLASS = 2
        const val BLACK_CLASS = 3
        const val UNKNOWN_CLASS = 0
    }
}