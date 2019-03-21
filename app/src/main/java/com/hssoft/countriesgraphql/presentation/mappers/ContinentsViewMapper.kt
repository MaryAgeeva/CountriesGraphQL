package com.hssoft.countriesgraphql.presentation.mappers

import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.entities.Country
import com.hssoft.countriesgraphql.domain.entities.Language
import com.hssoft.countriesgraphql.domain.extensions.emptyString
import com.hssoft.countriesgraphql.presentation.views.view_models_items.ContinentDetailViewItem
import com.hssoft.countriesgraphql.presentation.views.view_models_items.ContinentViewItem
import com.hssoft.countriesgraphql.presentation.views.view_models_items.CountryViewItem
import com.hssoft.countriesgraphql.presentation.views.view_models_items.LanguageViewItem

class ContinentsViewMapper {

    fun transformContinents(continents: List<Continent>) : List<ContinentViewItem> {
        return continents.map { ContinentViewItem(it.code, it.name) }
    }

    fun transformContinent(continent: Continent) : ContinentDetailViewItem {
        return ContinentDetailViewItem(continent.code, continent.name, continent.countries.map { transformCountry(it) })
    }

    fun transformCountry(country: Country) : CountryViewItem {
        return CountryViewItem(country.code, country.name, country.phone?: emptyString(),
            country.currency?: emptyString(), country.native?: emptyString(),
            country.emoji?: emptyString(),
            transformLanguages(country.languages))
    }

    private fun transformLanguages(languages: List<Language>) : List<LanguageViewItem> {
        return languages.map { LanguageViewItem(it.code, it.name) }
    }
}