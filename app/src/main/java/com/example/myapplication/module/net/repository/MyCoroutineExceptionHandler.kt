package com.example.myapplication.module.net.repository

import android.util.Log

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

class MyCoroutineExceptionHandler(override val key: CoroutineContext.Key<*>, private val resultCallBack: ApiResultCallback<*>? = null) : CoroutineExceptionHandler {

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        try {
            Log.e("Global error", exception.localizedMessage ?: "")
            resultCallBack?.onError()
        } catch (ex: Exception) {
            Log.e("Coroutine Exception", ex.localizedMessage ?: "")
        }
    }
}