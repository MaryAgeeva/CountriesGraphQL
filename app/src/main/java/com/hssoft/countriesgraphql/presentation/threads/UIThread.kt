package com.hssoft.countriesgraphql.presentation.threads

import com.hssoft.countriesgraphql.domain.utils.PostExecutor
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread : PostExecutor {
    override val sheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
