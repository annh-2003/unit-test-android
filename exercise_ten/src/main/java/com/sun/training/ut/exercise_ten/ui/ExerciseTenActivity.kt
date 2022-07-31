package com.sun.training.ut.exercise_ten.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.example.exercise_ten.R
import com.example.exercise_ten.databinding.ActivityExerciseTenBinding
import com.sun.training.ut.BR
import com.sun.training.ut.exercise_ten.di.exerciseModules
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class ExerciseTenActivity : BaseActivity<ActivityExerciseTenBinding, ExerciseTenViewModel>() {
    override val viewModel by viewModel<ExerciseTenViewModel>()

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId = R.layout.activity_exercise_ten

    override fun onCreate(savedInstanceState: Bundle?) {
        loadKoinModules(exerciseModules)
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this

    }

    override fun onDestroy() {
        unloadKoinModules(exerciseModules)
        super.onDestroy()
    }


}