package com.sun.training.ut.exercise_ten.ui

import android.os.Bundle
import com.example.exercise_ten.R
import com.example.exercise_ten.databinding.ActivityExerciseTenBinding
import com.sun.training.ut.BR
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ExerciseTenActivity : BaseActivity<ActivityExerciseTenBinding, ExerciseTenViewModel>() {

    override val viewModel: ExerciseTenViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_ten

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this

    }


}