package com.sun.training.ut.di

import com.sun.training.ut.data.local.prefs.AppPrefs
import com.sun.training.ut.data.local.prefs.PrefsHelper
import com.google.gson.Gson
import org.koin.dsl.module

/**
 * Declare storage component
 * @param get() is a component given
 */
val storageModule = module {
    single { Gson() }
    single<PrefsHelper> { AppPrefs(get(), get()) }
}
