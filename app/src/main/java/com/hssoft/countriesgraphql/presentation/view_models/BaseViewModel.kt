package com.hssoft.countriesgraphql.presentation.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hssoft.countriesgraphql.domain.exceptions.Failure
import com.hssoft.countriesgraphql.domain.exceptions.NoNetworkConnection
import java.lang.NullPointerException

abstract class BaseViewModel<T> : ViewModel() {
    val data : MutableLiveData<T> = MutableLiveData()
    val failures : MutableLiveData<Failure> = MutableLiveData()

    protected fun onFailure(e: Throwable) {
        val failure = when(e) {
            is NoNetworkConnection -> Failure.NoNetworkFailure
            is NullPointerException -> Failure.NoDataFailure
            else -> Failure.ServerFailure
        }
        failures.value = failure
    }
}