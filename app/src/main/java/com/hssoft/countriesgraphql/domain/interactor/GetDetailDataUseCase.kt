package com.hssoft.countriesgraphql.domain.interactor

import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.repositories.LocalData
import com.hssoft.countriesgraphql.domain.utils.BaseUseCase
import com.hssoft.countriesgraphql.domain.utils.PostExecutor
import io.reactivex.Single

class GetDetailDataUseCase(uiExecutor: PostExecutor,
                           private val localData: LocalData) : BaseUseCase<Continent, String>(uiExecutor) {

    override fun createSingle(params: String): Single<Continent> = localData.getContinent(params)
}