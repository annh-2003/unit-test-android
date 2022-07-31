package com.sun.training.ut.ui.exercise_four

import android.os.Bundle
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseFourBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ExerciseFourActivity : BaseActivity<ActivityExerciseFourBinding, ExerciseFourViewModel>() {

    override val viewModel: ExerciseFourViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_four

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
    }
}