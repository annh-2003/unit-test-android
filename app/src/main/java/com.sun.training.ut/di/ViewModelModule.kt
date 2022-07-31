package com.sun.training.ut.di

import com.sun.training.ut.ui.exercise_nine.ExerciseNineViewModel
import com.sun.training.ut.ui.excercise_six.ExerciseSixViewModel
import com.sun.training.ut.ui.exercise_eight.ExerciseEightViewModel
import com.sun.training.ut.ui.exercise_four.ExerciseFourViewModel
import com.sun.training.ut.ui.exercise_one.ExerciseOneViewModel
import com.sun.training.ut.ui.exercise_seven.ExerciseSevenViewModel
import com.sun.training.ut.ui.exercise_five.ExerciseFiveViewModel
import com.sun.training.ut.ui.exercise_three.ExerciseThreeViewModel
import com.sun.training.ut.ui.exercise_two.ExerciseTwoViewModel
import com.sun.training.ut.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Declare viewmodel component
 * @param get() is a component given
 */
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ExerciseOneViewModel() }
    viewModel { ExerciseTwoViewModel() }
    viewModel { ExerciseThreeViewModel() }
    viewModel { ExerciseFourViewModel() }
    viewModel { ExerciseFiveViewModel() }
    viewModel { ExerciseSixViewModel() }
    viewModel { ExerciseSevenViewModel() }
    viewModel { ExerciseEightViewModel() }
    viewModel { ExerciseNineViewModel() }
}

