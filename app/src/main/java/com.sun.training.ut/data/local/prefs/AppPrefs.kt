package com.sun.training.ut.data.local.prefs

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson

/**
 * Class for accessing and modifying data on local storage
 * */
class AppPrefs(
    context: Context,
    val gson: Gson
) : PrefsHelper {

    private val sharedPreferences by lazy {
        context.getSharedPreferences(
                context.packageName,
                Context.MODE_PRIVATE
        )
    }

    /**
     * Mark in the editor that a preference value should be removed
     *
     * @param key The name of the preference to remove.
     */
    override fun remove(key: String) {
        sharedPreferences.edit {
            remove(key)
        }
    }

    /**
     * Mark in the editor to remove <em>all</em> values from the
     * preferences.  Once commit is called, the only remaining preferences
     * will be any that you have defined in this editor.
     */
    override fun clear() {
        sharedPreferences.edit { clear() }
    }

    /**
     * Retrieve an int value from the preferences.
     * @param key The name of the preference to retrieve.
     * @param clazz classes instance of data type will be retrieve
     * @param defaultValue Value to return if this preference does not exist.
     *
     * @return Returns the preference value if it exists, or defValue.
     */
    override fun <T> get(key: String, clazz: Class<T>, defaultValue: T): T? {
        when (clazz) {
            String::class.java -> {
                return sharedPreferences.getString(key, defaultValue as String) as T
            }
            Boolean::class.java -> {
                return sharedPreferences.getBoolean(key, defaultValue as Boolean) as T
            }
            Float::class.java -> {
                return sharedPreferences.getFloat(key, defaultValue as Float) as T
            }
            Int::class.java -> {
                return sharedPreferences.getInt(key, defaultValue as Int) as T?
            }
            Long::class.java -> {
                return sharedPreferences.getLong(key, defaultValue as Long) as T
            }
            else -> return gson.fromJson(sharedPreferences.getString(key, ""), clazz)
        }
    }

    /**
     * Set a generic T value in the preferences editor
     *
     * @param key The name of the preference to modify.
     * @param data The new value for the preference.
     */
    override fun <T> put(key: String, data: T) {
        val editor = sharedPreferences.edit()
        when (data) {
            is String -> editor.putString(key, data as String)
            is Boolean -> editor.putBoolean(key, data as Boolean)
            is Float -> editor.putFloat(key, data as Float)
            is Int -> editor.putInt(key, data as Int)
            is Long -> editor.putLong(key, data as Long)
            else -> editor.putString(key, gson.toJson(data))
        }
        editor.apply()
    }
}
