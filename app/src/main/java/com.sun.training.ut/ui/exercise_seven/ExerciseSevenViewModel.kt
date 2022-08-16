package com.sun.training.ut.ui.exercise_seven

import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseSevenViewModel : BaseViewModel() {

    fun handleMonneyProduct(monney : Int) : Boolean {
        if(monney >= NUMBER_FIVE_THOUSAND) return true
        return false
    }

    fun handleTransportFee(
        isMonneyProduct : Boolean,
        isTypeClient : Boolean,
        isTypeTransport : Boolean
    ): Int {
        var transportNormal = NUMMBER_FIVE_HUNDRED
        var transportSuperSpeed = NUMMBER_ZERO

        if(isTypeTransport) transportSuperSpeed = NUMMBER_FIVE_HUNDRED
        if(isMonneyProduct || isTypeClient) transportNormal = NUMMBER_ZERO
        return  transportNormal +  transportSuperSpeed
    }

    companion object {
        const val NUMMBER_ZERO = 0
        const val NUMMBER_FIVE_HUNDRED = 500
        const val NUMBER_FIVE_THOUSAND = 5000
    }
}
