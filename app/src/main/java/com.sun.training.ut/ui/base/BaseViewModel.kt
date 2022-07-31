package com.sun.training.ut.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

/**
 * Base ViewModel
 */
abstract class BaseViewModel : ViewModel() {
    // loading flag
    val isLoading = MutableLiveData<Boolean>().apply { value = false }

    // error message
    val errorMessage = MutableLiveData<String>()

    // exception handler for coroutine
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        viewModelScope.launch {
            onLoadFail(throwable)
        }
    }

    // viewModelScope with exception handler
    protected val viewModelScopeExceptionHandler = viewModelScope + exceptionHandler

    /**
     * handle throwable when load fail
     */
    open suspend fun onLoadFail(throwable: Throwable) {
        withContext(Dispatchers.Main) {
            errorMessage.value = throwable.message
        }
    }

    fun showLoading() {
        isLoading.value = true
    }

    fun hideLoading() {
        isLoading.value = false
    }
}
