package com.hssoft.countriesgraphql.domain.utils

import io.reactivex.Scheduler
import java.util.concurrent.Executor

interface WorkerExecutor : Executor

interface PostExecutor {
    val sheduler: Scheduler
}