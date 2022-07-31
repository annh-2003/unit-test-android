package com.sun.training.ut.ui.home

import android.content.Intent
import android.os.Bundle
import com.sun.training.ut.BR
import com.sun.training.ut.R
import com.sun.training.ut.data.model.Exercise
import com.sun.training.ut.databinding.ActivityHomeBinding
import com.sun.training.ut.ui.base.BaseActivity
import com.sun.training.ut.ui.excercise_six.ExerciseSixActivity
import com.sun.training.ut.ui.exercise_eight.ExerciseEightActivity
import com.sun.training.ut.ui.exercise_five.ExerciseFiveActivity
import com.sun.training.ut.ui.exercise_nine.ExerciseNineActivity
import com.sun.training.ut.ui.exercise_four.ExerciseFourActivity
import com.sun.training.ut.ui.exercise_one.ExerciseOneActivity
import com.sun.training.ut.ui.exercise_seven.ExerciseSevenActivity
import com.sun.training.ut.ui.exercise_three.ExerciseThreeActivity
import com.sun.training.ut.ui.exercise_two.ExerciseTwoActivity
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Sample activity
 * Show list post got from URL_END_POINT = https://jsonplaceholder.typicode.com/
 */
@Suppress("UNCHECKED_CAST")
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), HomeItemClickListener {
    override val viewModel: HomeViewModel by viewModel()
    override val bindingVariable = BR.viewModel
    override val layoutId = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAdapter()
    }

    private fun setUpAdapter() {
        viewBinding.adapter = HomeAdapter(this).apply {
            submitList(
                listOf(
                    Exercise("Ex1: Bia hơi Keangnam", ExerciseOneActivity::class.java),
                    Exercise("Ex2: ATM của ngân hàng Việt Nam", ExerciseTwoActivity::class.java),
                    Exercise("Ex3: Quần áo nam trên Hoàn Kiếm", ExerciseThreeActivity::class.java),
                    Exercise(
                        "Ex4: Mr.A đang làm 1 app về calendar",
                        ExerciseFourActivity::class.java
                    ),
                    Exercise("Ex5: 8 pieces pizza", ExerciseFiveActivity::class.java),
                    Exercise("Ex6: Trung tâm mua sắm Tây Hồ", ExerciseSixActivity::class.java),
                    Exercise("Ex7: Vietnam Mart", ExerciseSevenActivity::class.java),
                    Exercise(
                        "Ex8: Mr. A đến một sân chơi nọ để chơi cầu lông",
                        ExerciseEightActivity::class.java
                    ),
                    Exercise("Ex9: Roll Playng Game Hanoi quest", ExerciseNineActivity::class.java),
                    Exercise("Ex10: Nhà hàng Nam Từ Liêm", getClazzTen())
                )
            )
        }
    }

    override fun onHomeItemClicked(item: Exercise<*>) {
        try {
            startActivity(Intent(this, item.clz))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getClazzTen(): Class<BaseActivity<*, *>> {
        val clzz = Class.forName(EXERCISE_TEN_CLASSNAME)
        return clzz as? Class<BaseActivity<*, *>> ?: (this::class.java as Class<BaseActivity<*, *>>)
    }

    companion object {
        private const val PACKAGE_NAME = "com.sun.training.ut"
        private const val EXERCISE_TEN_CLASSNAME = "$PACKAGE_NAME.exercise_ten.ui.ExerciseTenActivity"
    }
}
