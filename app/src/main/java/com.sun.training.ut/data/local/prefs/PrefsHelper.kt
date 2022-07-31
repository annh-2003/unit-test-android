package com.sun.training.ut.data.local.prefs

interface PrefsHelper {
    fun remove(key: String)

    fun clear()

    fun <T> get(key: String, clazz: Class<T>, defaultValue: T): T?

    fun <T> put(key: String, data: T)
}
