package com.sun.training.ut.ui.exercise_eight

import android.os.Bundle
import android.util.TypedValue
import android.widget.EditText
import android.widget.NumberPicker
import androidx.recyclerview.widget.GridLayoutManager
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.data.Constant
import com.sun.training.ut.data.Constant.BADMINTON_MAX_AGE
import com.sun.training.ut.data.Constant.BADMINTON_MIN_AGE
import com.sun.training.ut.data.model.No8Member
import com.sun.training.ut.databinding.ActivityExerciseEightBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel
import android.view.View


class ExerciseEightActivity : BaseActivity<ActivityExerciseEightBinding, ExerciseEightViewModel>() {

    override val viewModel: ExerciseEightViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_eight

    var layoutManager: GridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this

    }
}