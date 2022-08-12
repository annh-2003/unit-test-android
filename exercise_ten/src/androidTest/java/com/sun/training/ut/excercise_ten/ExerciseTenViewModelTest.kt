package com.sun.training.ut.excercise_ten

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sun.training.ut.exercise_ten.di.exerciseModules
import com.sun.training.ut.exercise_ten.di.viewModelModule
import com.sun.training.ut.exercise_ten.ui.ExerciseTenViewModel
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class ExerciseTenViewModelTest : KoinTest {

    val viewModel: ExerciseTenViewModel by inject()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(exerciseModules)
    }

    @Before
    fun setup() {
        startKoin {
            module { single { viewModelModule} }

        }
    }

    @Test
    fun test() {
        assertEquals(10, viewModel.a)
    }


}