package com.hssoft.countriesgraphql.domain.exceptions

sealed class Failure {

    object NoNetworkFailure : Failure()

    object ServerFailure : Failure()

    object NoDataFailure : Failure()

    object NoDetailDataFailure : Failure()
}