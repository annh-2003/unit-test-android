package com.sun.training.ut

import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.sun.training.ut.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Declare application context of app
 * start Koin injection by startKoin {} DSL
 */
class MainApplication : SplitCompatApplication() {
    override fun onCreate() {
        super.onCreate()
        SplitCompat.install(this)

        startKoin {
            androidLogger() //Koin log
            androidContext(this@MainApplication) //declare used Android context
            modules(appModules) //declare modules
        }
    }
}
