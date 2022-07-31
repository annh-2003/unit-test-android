package com.sun.training.ut.di

import com.sun.training.ut.data.repository.SampleRepository
import com.sun.training.ut.data.repository.impl.SampleRepositoryImpl
import org.koin.dsl.module

/**
 * Declare repository component
 * @param get() is a component given
 */
val repositoryModule = module {
    single<SampleRepository> { SampleRepositoryImpl(get()) }
}
