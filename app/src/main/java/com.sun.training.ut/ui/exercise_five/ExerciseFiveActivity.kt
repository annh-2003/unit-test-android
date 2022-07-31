package com.sun.training.ut.ui.exercise_five

import android.os.Bundle
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseFiveBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ExerciseFiveActivity : BaseActivity<ActivityExerciseFiveBinding, ExerciseFiveViewModel>() {

    override val viewModel: ExerciseFiveViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_five

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
    }
}