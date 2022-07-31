package com.sun.training.ut.exercise_ten.di

import com.sun.training.ut.exercise_ten.ui.ExerciseTenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ExerciseTenViewModel(androidContext().resources) }
}