package com.sun.training.ut.ui.exercise_three

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ActivityExerciseThreeBinding
import com.sun.training.ut.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_exercise_three.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExerciseThreeActivity : BaseActivity<ActivityExerciseThreeBinding, ExerciseThreeViewModel>() {
    override val viewModel: ExerciseThreeViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_exercise_three

    private val adapterProduct by lazy { ProductAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.lifecycleOwner = this
        viewBinding.apply {
            listView.layoutManager = LinearLayoutManager(this@ExerciseThreeActivity)
            listView.adapter = adapterProduct
            btnViewProduct.setOnClickListener {
                listenerViewProduct()
            }
        }

        viewModel.productLivedata.observe(this) {
            adapterProduct.setList(it)
        }

        adapterProduct.clickAddCount = { position ->
            viewModel.addCount(position)
        }

        btnCalculateMoney.setOnClickListener {
            tvResultTotal.text = viewModel.handleData(
                viewModel.checkAoSoMi(),
                viewModel.checkCaVat(),
                viewModel.checkAmountProduct()
            ).toString()
        }
    }

    private fun listenerViewProduct(){
        val listItems = arrayOf(
            "Áo sơ mi trắng",
            "Cà vạt",
            "Quần bơi",
            "Áo vest đen",
            "Quần tây đen",
            "Áo sơ mi đen",
            "Nón cối",
            "Dép tông lào",
            "Điều cầy thượng hang",
            "Dép tổ ông")

        val builder = AlertDialog.Builder(this).apply {
            setTitle("Lựa chọn sản phẩm")
            var position = 0
            setSingleChoiceItems(listItems, 0, DialogInterface.OnClickListener { dialog, which ->
                position = which
            })
            setPositiveButton("OK") {dialog, which ->
                when(position){
                    0 -> {viewModel.addProduct(0)}
                    1 -> {viewModel.addProduct(1)}
                    2 -> {viewModel.addProduct(2)}
                    3 -> {viewModel.addProduct(3)}
                    4 -> {viewModel.addProduct(4)}
                    5 -> {viewModel.addProduct(5)}
                    6 -> {viewModel.addProduct(6)}
                    7 -> {viewModel.addProduct(7)}
                    8 -> {viewModel.addProduct(8)}
                    9 -> {viewModel.addProduct(9)}
                }
            }
            setNeutralButton("Cancel") {dialog , which ->
                dialog.dismiss()
            }
        }
        builder.show()
    }
}
