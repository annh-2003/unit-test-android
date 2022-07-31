package com.sun.training.ut.ui.exercise_two

import android.os.Bundle
import android.util.Log
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseTwoBinding
import com.sun.training.ut.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_exercise_two.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExerciseTwoActivity : BaseActivity<ActivityExerciseTwoBinding, ExerciseTwoViewModel>() {

    override val viewModel: ExerciseTwoViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_two

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
    }
}