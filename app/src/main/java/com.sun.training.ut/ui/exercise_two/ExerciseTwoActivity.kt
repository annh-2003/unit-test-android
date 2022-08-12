package com.sun.training.ut.ui.exercise_two

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.DatePicker
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseTwoBinding
import com.sun.training.ut.databinding.DateTimePickerBinding
import com.sun.training.ut.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_exercise_two.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.Inflater

class ExerciseTwoActivity : BaseActivity<ActivityExerciseTwoBinding, ExerciseTwoViewModel>() {

    override val viewModel: ExerciseTwoViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_two
    private lateinit var alertDialog: AlertDialog
    private lateinit var dialog: DateTimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
        alertDialog = AlertDialog.Builder(this@ExerciseTwoActivity).create()
        dialog = DateTimePickerBinding.inflate(LayoutInflater.from(this))
        alertDialog.setView(viewBinding.root)
    }

    override fun onStart() {
        super.onStart()
        dialog.apply {
            dateTimeSet.setOnClickListener {
                val calendar = GregorianCalendar(
                    datePicker.year,
                    datePicker.month,
                    datePicker.dayOfMonth,
                    timePicker.hour,
                    timePicker.minute
                )
                viewModel.myCalendar = calendar
                viewModel.updateCalendar()
                alertDialog.dismiss()
            }
        }

        viewBinding.apply {
            btn.setOnClickListener {
                alertDialog.setView(dialog.root)
                alertDialog.show()
            }
        }

        viewModel.apply {
            isVipMember.observe(this@ExerciseTwoActivity) {
                updateCalendar()
            }
        }

    }
}