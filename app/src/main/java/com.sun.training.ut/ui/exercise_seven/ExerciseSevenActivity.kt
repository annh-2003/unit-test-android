package com.sun.training.ut.ui.exercise_seven

import android.os.Bundle
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseSevenBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ExerciseSevenActivity : BaseActivity<ActivityExerciseSevenBinding, ExerciseSevenViewModel>() {

    override val viewModel: ExerciseSevenViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_seven

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
    }
}