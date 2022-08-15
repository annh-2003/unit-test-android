package com.sun.training.ut.ui.exercise_five

import android.os.Bundle
import android.util.Log
import androidx.core.widget.doOnTextChanged
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseFiveBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception

class ExerciseFiveActivity : BaseActivity<ActivityExerciseFiveBinding, ExerciseFiveViewModel>() {

    override val viewModel: ExerciseFiveViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_five

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this

    }

    override fun onStart() {
        super.onStart()


        viewModel.apply {
            viewBinding.edPizzaNum.doOnTextChanged { text, start, count, after ->
                try {
                    numPizza.value = text.toString().toInt()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            viewBinding.edPizzaPrice.doOnTextChanged { text, start, count, after ->
                try {
                    pricePizza.value = text.toString().toInt()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}