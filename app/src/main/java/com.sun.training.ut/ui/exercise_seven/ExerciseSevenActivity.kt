package com.sun.training.ut.ui.exercise_seven

import android.os.Bundle
import android.widget.Toast
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

        viewBinding.btnTotalMonney.setOnClickListener {
            val srtMonneyProduct = viewBinding.edtMonneyProduct.text.toString().trim()
            if (srtMonneyProduct == "") {
                Toast.makeText(this, "Invalid monney product", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewBinding.tvResultTotalTransportFee.text =
                viewModel.handleTransportFee(
                    viewModel.handleMonneyProduct(srtMonneyProduct.toInt()),
                    checkIdRadioClient(),
                    checkIdRadioTransport()
                ).toString()
        }
    }

    private fun checkIdRadioClient(): Boolean {
        viewBinding.apply {
            val idRadioChecked = radioGruopTypeClient.checkedRadioButtonId
            return idRadioChecked == R.id.radioClientPremium
        }
    }

    private fun checkIdRadioTransport(): Boolean {
        viewBinding.apply {
            val idRadioChecked = radioGruopTypeTransport.checkedRadioButtonId
            return idRadioChecked == R.id.radioTransportSuperSpeed
        }
    }
}
