package com.sun.training.ut.data.remote

import com.sun.training.ut.BuildConfig
import android.content.Context
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Depend on each API, it will be handled particularly
 */
object ApiService {

    private const val TIMEOUT = 10L

    /**
     * Custom [okhttp3.Interceptor] for special header make safe request
     */
    fun createHeaderInterceptor(): Interceptor =
        Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url.newBuilder()
                .build()
            val newRequest = request.newBuilder()
                .url(newUrl)
//            .header("Content-Type", "application/json")
                .method(request.method, request.body)
                .build()
            chain.proceed(newRequest)
        }

    /**
     * logs request and response information
     * */
    fun createLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }

    /**
     * Config cache size
     * */
    fun createOkHttpCache(context: Context): Cache =
        Cache(context.cacheDir, (10 * 1024 * 1024).toLong())

    /**
     * Build [okhttp3.OkHttpClient] with custom config
     * */
    fun createOkHttpClient(
        logging: Interceptor,
        header: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
//                .cache(cache)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(header)
            .addInterceptor(logging)
            .build()

    /**
     * Build retrofit
     * */
    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.URL_END_POINT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}
