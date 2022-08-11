package com.sun.training.ut.ui.exercise_one

import android.os.Build
import android.os.Bundle
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseOneBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ExerciseOneActivity : BaseActivity<ActivityExerciseOneBinding, ExerciseOneViewModel>() {

    override val viewModel: ExerciseOneViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_one

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
        viewBinding.apply {
            pickerTimeOrder.setIs24HourView(true)
            btnCalculate.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    viewModel?.calculatorTotalAmount(
                        hour = pickerTimeOrder.hour,
                        voucher = switchIsHaveVoucher.isChecked,
                        beersAmount = inputBearsNumber.text.toString().toIntOrNull() ?: 0
                    )
                } else {
                    viewModel?.calculatorTotalAmount(
                        hour = pickerTimeOrder.currentHour,
                        voucher = switchIsHaveVoucher.isChecked,
                        beersAmount = inputBearsNumber.text.toString().toIntOrNull() ?: 0
                    )
                }
            }
        }
    }
}
