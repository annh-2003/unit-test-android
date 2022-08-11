package com.sun.training.ut.ui.exercise_eight

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseEightBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel
import android.widget.ArrayAdapter


class ExerciseEightActivity : BaseActivity<ActivityExerciseEightBinding, ExerciseEightViewModel>() {

    override val viewModel: ExerciseEightViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_eight

    var layoutManager: GridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
        val adapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            dayOfWeeks
        )
        viewBinding.apply {
            pickDay.adapter = adapter
            btnCalculate.setOnClickListener {
                viewModel?.checkFee(
                    dayOfWeek = pickDay.selectedItem.toString(),
                    female = radioFemale.isChecked,
                    age = inputAge.text.toString().toIntOrNull() ?: -1
                )
            }
        }
    }

    companion object {
        val dayOfWeeks = arrayListOf<String>(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        )
    }
}
