package com.sun.training.ut.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Declare component
 */
val appModule = module {
    single { androidApplication().resources }
}

/**
 * Declare all component
 */
val appModules = listOf(appModule, networkModule, repositoryModule, storageModule, viewModelModule)
