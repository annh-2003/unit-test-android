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
        if (isHaveDuaPhepOrQuanSu() && chiaKhoaBongDem.value!! && kiemAnhSang.value!!) message.value = "Danh bai boss thanh cong!"
        else if (isHaveDuaPhepOrQuanSu() && !chiaKhoaBongDem.value!! && !kiemAnhSang.value!!) message.value = "Thieu chia khoa bong dem & kiem anh sang de danh boss"
        else if (isHaveDuaPhepOrQuanSu() && chiaKhoaBongDem.value!! && !kiemAnhSang.value!!) message.value = "Thieu kiem anh sang de danh boss"
        else if (isHaveDuaPhepOrQuanSu() && !chiaKhoaBongDem.value!! && kiemAnhSang.value!!) message.value = "Thieu chia khoa bong dem de danh boss"
        else if (!isHaveDuaPhepOrQuanSu() && chiaKhoaBongDem.value!! && !kiemAnhSang.value!!) message.value = "Thieu kiem anh sang & dua phep hoac quan su de danh boss"
        else if (!isHaveDuaPhepOrQuanSu() && !chiaKhoaBongDem.value!! && kiemAnhSang.value!!) message.value = "Thieu chia khoa bong dem & dua phep hoac quan su de danh boss"
        else if (!isHaveDuaPhepOrQuanSu() && chiaKhoaBongDem.value!! && kiemAnhSang.value!!) message.value = "Thieu dua phep hoac quan su de danh boss"
        else message.value = "Ban khong co item nao de danh boss"

    }

    fun isHaveDuaPhepOrQuanSu():Boolean = duaPhep.value!! || quanSu.value!!
}
