package com.hssoft.countriesgraphql.presentation.view_models

import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.interactor.GetAllDataUseCase
import com.hssoft.countriesgraphql.presentation.mappers.ContinentsViewMapper
import com.hssoft.countriesgraphql.presentation.views.view_models_items.ContinentViewItem

class ContinentsViewModel(private val getAllDataUseCase: GetAllDataUseCase,
                          private val mapper: ContinentsViewMapper) : BaseViewModel<List<ContinentViewItem>>() {

    fun getAllItems() {
        getAllDataUseCase.run(::onSuccess, ::onError, Unit)
    }

    private fun onSuccess(continents: List<Continent>) {
        data.value = mapper.transformContinents(continents)
    }

    private fun onError(e: Throwable) = onFailure(e)
}
