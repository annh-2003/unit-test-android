package com.sun.training.ut.ui.exercise_eight

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.data.Constant
import com.sun.training.ut.databinding.ActivityExerciseEightBinding
import com.sun.training.ut.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_exercise_eight.*
import kotlinx.android.synthetic.main.activity_exercise_five.*


class ExerciseEightActivity : BaseActivity<ActivityExerciseEightBinding, ExerciseEightViewModel>() {

    override val viewModel: ExerciseEightViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_eight

    var layoutManager: GridLayoutManager? = null
    var dayOfWeekAdapter: DayOfWeekAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
        setupAdapter()
        setupSpinnerGender()
        watchAgeFormInput()
    }


    private fun watchAgeFormInput() {
        edtAge.addTextChangedListener {
            viewModel.ageFormInput.value = it.toString().toIntOrNull() ?: 0
        }
    }

    private fun setupSpinnerGender() {
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            Constant.Gender.values().toList()
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerChooseGender.adapter = adapter
            spinnerChooseGender.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        if (position == 0)
                            viewModel.genderFromInput.value = Constant.Gender.MALE
                        else
                            viewModel.genderFromInput.value = Constant.Gender.FEMALE
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
        }
    }

    private fun setupAdapter() {
        layoutManager = GridLayoutManager(this, 1, RecyclerView.HORIZONTAL, false)
        dayOfWeekAdapter = DayOfWeekAdapter(
            clickCallback = { _, index ->
                viewModel.dayOfWeekFromInput.value = Constant.DayOfWeek.values()[index]
            }, layoutManager = layoutManager!!
        ).also { adapter ->
            recycler.adapter = adapter
            recycler.layoutManager = layoutManager
            recycler.addItemDecoration(GridSpaceItemDecoration(0, 1))
            adapter.listItem = resources.getStringArray(R.array.day_of_week)
                .toList() as ArrayList<String> /* = java.util.ArrayList<kotlin.String> */
        }
    }
}