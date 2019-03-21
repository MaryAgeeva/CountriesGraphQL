package com.hssoft.countriesgraphql.presentation.view_models

import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.interactor.GetDetailDataUseCase
import com.hssoft.countriesgraphql.presentation.mappers.ContinentsViewMapper
import com.hssoft.countriesgraphql.presentation.views.view_models_items.ContinentDetailViewItem

class CountriesViewModel(private val getDetailUseCase: GetDetailDataUseCase,
                         private val mapper: ContinentsViewMapper) : BaseViewModel<ContinentDetailViewItem>() {

    fun getCountries(code: String) {
        getDetailUseCase.run(::onSuccess, ::onFailure, code)
    }

    private fun onSuccess(continent: Continent) {
        data.value = mapper.transformContinent(continent)
    }
}
