package com.sun.training.ut.ui.exercise_nine

import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseNineViewModel : BaseViewModel() {
    val magicChopstick = MutableLiveData(false)
    val tactician = MutableLiveData(false)
    val darknessKey = MutableLiveData(false)
    val sword = MutableLiveData(false)
    val message = MutableLiveData<String>()

    fun magicChopstickState(b: Boolean){
        magicChopstick.value = b
    }

    fun tacticianState(b: Boolean){
        tactician.value = b
    }

    fun darknessKey(b: Boolean){
        darknessKey.value = b
    }

    fun swordState(b: Boolean){
        sword.value = b
    }

    fun attackBoss(){
        if (isHaveMagicChopstickOrTactician() && isHaveDarknessKeyAndSword()) message.value = "Danh bai boss thanh cong!"
        else if (isHaveMagicChopstickOrTactician() && isNotHaveDarknessKeyAndSword()) message.value = "Thieu chia khoa bong dem & kiem anh sang de danh boss"
        else if (isHaveMagicChopstickOrTactician() && isHaveDarknessKeyAndNotSword()) message.value = "Thieu kiem anh sang de danh boss"
        else if (isHaveMagicChopstickOrTactician() && isNotDarknessKeyAndHaveSword()) message.value = "Thieu chia khoa bong dem de danh boss"
        else if (!isHaveMagicChopstickOrTactician() && isHaveDarknessKeyAndNotSword()) message.value = "Thieu kiem anh sang & dua phep hoac quan su de danh boss"
        else if (!isHaveMagicChopstickOrTactician() && isNotDarknessKeyAndHaveSword()) message.value = "Thieu chia khoa bong dem & dua phep hoac quan su de danh boss"
        else if (!isHaveMagicChopstickOrTactician() && isHaveDarknessKeyAndSword()) message.value = "Thieu dua phep hoac quan su de danh boss"
        else message.value = "Ban khong co item nao de danh boss"
    }

    private fun isHaveMagicChopstickOrTactician():Boolean = magicChopstick.value!! || tactician.value!!

    private fun isHaveDarknessKeyAndSword(): Boolean = darknessKey.value!! && sword.value!!

    private fun isNotHaveDarknessKeyAndSword(): Boolean = !darknessKey.value!! && !sword.value!!

    private fun isHaveDarknessKeyAndNotSword(): Boolean = darknessKey.value!! && !sword.value!!

    private fun isNotDarknessKeyAndHaveSword(): Boolean = !darknessKey.value!! && sword.value!!
}
