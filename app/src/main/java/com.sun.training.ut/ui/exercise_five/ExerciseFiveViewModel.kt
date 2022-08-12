package com.sun.training.ut.ui.exercise_five

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseFiveViewModel : BaseViewModel() {
    val atStore = MutableLiveData(false)
    var numPizza = MutableLiveData(0)
    var pricePizza = MutableLiveData(0)
    val haveCoupon = MediatorLiveData<Boolean>().apply {
        value = false
        addSource(atStore) {
            if (atStore.value == true) value = false
        }
    }

    private val _calPrice = MediatorLiveData<Int>().apply {
        addSource(numPizza) {
            value = calPrice()
        }

        addSource(pricePizza) {
            value = calPrice()
        }

        addSource(atStore) {
            value = calPrice()
        }

        addSource(haveCoupon) {
            value = calPrice()
        }
    }

    val calPrice: LiveData<Int>
        get() = _calPrice

    private val _freeCorn = MediatorLiveData<Boolean>().apply {
        addSource(calPrice) {
            value = ((numPizza.value ?: 0) * (pricePizza.value ?: 0)) > 1500
        }
    }

    val freeCorn: LiveData<Boolean>
        get() = _freeCorn

    fun calPrice(discountRatio: Double = 0.8): Int {
        return when (haveCoupon.value) {
            true -> ((numPizza.value ?: 0) * (pricePizza.value ?: 0) * discountRatio).toInt()
            else -> ((numPizza.value ?: 0) * (pricePizza.value ?: 0))
        }
    }

    private val _totalPizza = MediatorLiveData<Int>().apply {
        value = 0
        addSource(atStore) {
            value = when (atStore.value) {
                true -> (numPizza.value ?: 0) + 1
                else -> numPizza.value
            }
        }

        addSource(numPizza) {
            value = when (atStore.value) {
                true -> (numPizza.value ?: 0) + 1
                else -> numPizza.value
            }
        }
    }

    val totalPizza: LiveData<Int>
        get() = _totalPizza
}