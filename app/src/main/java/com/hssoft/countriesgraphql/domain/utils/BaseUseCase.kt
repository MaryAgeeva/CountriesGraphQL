package com.hssoft.countriesgraphql.domain.utils

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase<T, Params>(private val postExecutor: PostExecutor) {

    private val disposable: CompositeDisposable = CompositeDisposable()

    abstract fun createSingle(params: Params) : Single<T>

    open fun run(success: (T) -> Unit, errorCall: (Throwable) -> Unit, params: Params) {
        disposable.add(createSingle(params).subscribeOn(Schedulers.io())
            .observeOn(postExecutor.sheduler)
            .subscribe({ success(it) }, {errorCall(it)}))
    }

    fun dispose() {
        if(!disposable.isDisposed) disposable.dispose()
    }
}