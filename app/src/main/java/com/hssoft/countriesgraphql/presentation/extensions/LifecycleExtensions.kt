package com.hssoft.countriesgraphql.presentation.extensions

import androidx.lifecycle.*
import com.hssoft.countriesgraphql.domain.exceptions.Failure

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<Failure>> LifecycleOwner.failure(liveData: L, body: (Failure?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <T> LiveData<T>.subscribe(owner: LifecycleOwner, success: (T) -> Unit) =
        observe(owner, Observer { success(it) })