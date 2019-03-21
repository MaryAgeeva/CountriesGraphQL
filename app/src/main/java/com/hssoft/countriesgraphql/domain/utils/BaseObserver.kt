package com.hssoft.countriesgraphql.domain.utils

import io.reactivex.observers.DisposableSingleObserver

abstract class BaseObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {}

    override fun onError(e: Throwable) {}
}