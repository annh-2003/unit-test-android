package com.sun.training.ut.ui.exercise_nine

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseNineViewModel : BaseViewModel() {
    val duaPhep = MutableLiveData(false)
    val quanSu = MutableLiveData(false)
    val chiaKhoaBongDem = MutableLiveData(false)
    val kiemAnhSang = MutableLiveData(false)
    val message = MutableLiveData<String>()

    fun duaPhepState(b: Boolean){
        duaPhep.value = b
    }

    fun quanSuState(b: Boolean){
        quanSu.value = b
    }

    fun chiaKhoaBongDemState(b: Boolean){
        chiaKhoaBongDem.value = b
    }

    fun kiemAnhSangState(b: Boolean){
        kiemAnhSang.value = b
    }

    fun attackBoss(){
        if (isHaveDuaPhepOrQuanSu() && isHaveChiaKhoaAndKiem()) message.value = "Danh bai boss thanh cong!"
        else if (isHaveDuaPhepOrQuanSu() && isNotHaveChiaKhoaAndKiem()) message.value = "Thieu chia khoa bong dem & kiem anh sang de danh boss"
        else if (isHaveDuaPhepOrQuanSu() && isHaveChiaKhoaAndNotKiem()) message.value = "Thieu kiem anh sang de danh boss"
        else if (isHaveDuaPhepOrQuanSu() && isNotChiaKhoaAndHaveKiem()) message.value = "Thieu chia khoa bong dem de danh boss"
        else if (!isHaveDuaPhepOrQuanSu() && isHaveChiaKhoaAndNotKiem()) message.value = "Thieu kiem anh sang & dua phep hoac quan su de danh boss"
        else if (!isHaveDuaPhepOrQuanSu() && isNotChiaKhoaAndHaveKiem()) message.value = "Thieu chia khoa bong dem & dua phep hoac quan su de danh boss"
        else if (!isHaveDuaPhepOrQuanSu() && isHaveChiaKhoaAndKiem()) message.value = "Thieu dua phep hoac quan su de danh boss"
        else message.value = "Ban khong co item nao de danh boss"

    }

    private fun isHaveDuaPhepOrQuanSu():Boolean = duaPhep.value!! || quanSu.value!!

    private fun isHaveChiaKhoaAndKiem(): Boolean = chiaKhoaBongDem.value!! && kiemAnhSang.value!!

    private fun isNotHaveChiaKhoaAndKiem(): Boolean = !chiaKhoaBongDem.value!! && !kiemAnhSang.value!!

    private fun isHaveChiaKhoaAndNotKiem(): Boolean = chiaKhoaBongDem.value!! && !kiemAnhSang.value!!

    private fun isNotChiaKhoaAndHaveKiem(): Boolean = !chiaKhoaBongDem.value!! && kiemAnhSang.value!!
}
