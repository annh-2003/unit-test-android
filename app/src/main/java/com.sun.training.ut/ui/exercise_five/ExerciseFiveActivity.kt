package com.sun.training.ut.ui.exercise_five

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.data.Constant
import com.sun.training.ut.databinding.ActivityExerciseFiveBinding
import com.sun.training.ut.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_exercise_five.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExerciseFiveActivity : BaseActivity<ActivityExerciseFiveBinding, ExerciseFiveViewModel>() {

    override val viewModel: ExerciseFiveViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_five

    lateinit var adapterCoupon: SpinnerItemAdapter<Constant.Coupon>
    private val listItemSpinnerCoupon: MutableList<Constant.Coupon> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
        listItemSpinnerCoupon.addAll(Constant.Coupon.values().toList())
        setupSpinnerChooseTypeDelivery()
        setupSpinnerChooseCoupon()
        watchTotalBillFormInput()
    }

    private fun watchTotalBillFormInput() {
        edtTotalBill.addTextChangedListener {
            viewModel.totalBillFormInput.value = it.toString().toIntOrNull() ?: 0
        }
    }

    private fun setupSpinnerChooseCoupon() {
        adapterCoupon = SpinnerItemAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listItemSpinnerCoupon
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerChooseCoupon.adapter = adapter
            spinnerChooseCoupon.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        when (position) {
                            Constant.Coupon.OFF_20.ordinal ->
                                viewModel.isCoupon.value = Constant.Coupon.OFF_20
                            Constant.Coupon.POTATO_PROMOTION.ordinal ->
                                viewModel.isCoupon.value = Constant.Coupon.POTATO_PROMOTION
                            Constant.Coupon.PIZZA_SECOND_FREE.ordinal ->
                                viewModel.isCoupon.value = Constant.Coupon.PIZZA_SECOND_FREE
                            Constant.Coupon.REGULAR_FEE.ordinal ->
                                viewModel.isCoupon.value = Constant.Coupon.REGULAR_FEE
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
        }
    }

    private fun setupSpinnerChooseTypeDelivery() {
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            Constant.TypeDelivery.values().toList()
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerChooseTypeDelivery.adapter = adapter
            spinnerChooseTypeDelivery.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        if (position == Constant.TypeDelivery.DELIVERY.ordinal) {
                            viewModel.typeDelivery.value = Constant.TypeDelivery.DELIVERY
                            spinnerChooseCoupon.setSelection(Constant.Coupon.REGULAR_FEE.ordinal)
                            spinnerChooseCoupon.isEnabled = true
                        } else {
                            viewModel.typeDelivery.value = Constant.TypeDelivery.RECEIVE_AT_STORE
                            spinnerChooseCoupon.setSelection(Constant.Coupon.PIZZA_SECOND_FREE.ordinal)
                            spinnerChooseCoupon.isEnabled = false
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
        }
    }
}