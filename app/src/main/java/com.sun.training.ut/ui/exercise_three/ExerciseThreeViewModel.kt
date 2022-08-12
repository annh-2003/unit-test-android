package com.sun.training.ut.ui.exercise_three

import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseThreeViewModel : BaseViewModel() {

    val mListProduct = mutableListOf<Product>()
    private val _productLivedata = MutableLiveData<List<Product>>()
    val productLivedata: MutableLiveData<List<Product>>
        get() = _productLivedata

    fun addProduct(position: Int?) {
        position?.let {
            if (mListProduct.isEmpty()) mListProduct.add(ListProduct.getListProduct().get(it))
            else  {
                for (i in mListProduct) {
                    if (position == i.id) {
                        return
                    }
                }
                mListProduct.add(ListProduct.getListProduct()[it])
            }
            _productLivedata.value = mListProduct
        }
    }

    fun addCount(position: Int){
        val product = mListProduct[position]
        mListProduct[position] = Product(
            product.id,
            product.nameOfProduct,
            product.priceOfProduct,
            product.countOfProduct+1
        )
        _productLivedata.value = mListProduct
    }

    fun  checkAmountProduct(): Boolean{
        return  mListProduct.size >= NUMBER_SEVEN
    }

    fun checkAoSoMi(): Boolean {
        for (i in mListProduct) {
            return i.id == NUMBER_ZERO
        }
        return false
    }

    fun checkCaVat(): Boolean {
        for (i in mListProduct) {
            return i.id == NUMBER_ONE
        }
        return false
    }

    fun getMonney(): Int {
        var monney = NUMBER_ZERO
        for (i in mListProduct) {
            if (i.countOfProduct > 1)  monney = (monney + (i.priceOfProduct * i.countOfProduct)).toInt()
            else monney = (monney + i.priceOfProduct).toInt()
        }
        return monney
    }

    fun handleData(isCheckAOSOMI : Boolean, isCheckCAVAT : Boolean, isCheckAMOUNT  : Boolean ): Int{
        return if (!isCheckAOSOMI && !isCheckCAVAT && isCheckAMOUNT) (getMonney() / NUMBER_A_HUNDRED) * NUMBER_NINETY_THREE
        else if (isCheckAOSOMI && isCheckCAVAT && !isCheckAMOUNT) (getMonney() / NUMBER_A_HUNDRED) * NUMBER_NINETY_FIVE
        else if (isCheckAOSOMI && isCheckCAVAT && isCheckAMOUNT) (getMonney() / NUMBER_A_HUNDRED) * NUMBER_EIGHTY_EIGHT
        else  getMonney()
    }

    companion object {
        const val NUMBER_ZERO = 0
        const val NUMBER_ONE = 1
        const val NUMBER_SEVEN = 7
        const val NUMBER_A_HUNDRED = 100
        const val NUMBER_NINETY_THREE = 93
        const val NUMBER_NINETY_FIVE = 95
        const val NUMBER_EIGHTY_EIGHT = 88
    }
}
