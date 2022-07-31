package com.sun.training.ut.di

import com.sun.training.ut.data.remote.ApiService
import com.sun.training.ut.data.remote.ApiServiceInterface
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Declare network component
 * @param get() is a component given
 * @see named() is used to name a component when declare, can get component by name declared
 */
val networkModule = module {
//    single { createOkHttpCache(get()) }
    single(named("header")) { ApiService.createHeaderInterceptor() } //Naming to identity element
    single(named("logging")) { ApiService.createLoggingInterceptor() }
    single { ApiService.createOkHttpClient(get(named("header")), get(named("logging"))) }
    single { ApiService.createRetrofit(get()) }
    single { createApiService<ApiServiceInterface>(get()) }
}

/**
 * Create api service
 */
inline fun <reified T> createApiService(retrofit: Retrofit): T =
    retrofit.create(T::class.java)
