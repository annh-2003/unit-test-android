package com.sun.training.ut.ui.exercise_four

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseFourBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel


class ExerciseFourActivity : BaseActivity<ActivityExerciseFourBinding, ExerciseFourViewModel>() {

    override val viewModel: ExerciseFourViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_four

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this

        viewModel.color.observe(this){
            when(it){
                RuleColor.RED -> viewBinding.ivColor.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                RuleColor.GREEN -> viewBinding.ivColor.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                RuleColor.BLACK -> viewBinding.ivColor.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlack))
                else -> return@observe
            }
        }

        viewBinding.dp.setOnDateChangedListener { datePicker, _, _, _ ->
            viewModel.dayChosen(datePicker!!)
        }
    }
}