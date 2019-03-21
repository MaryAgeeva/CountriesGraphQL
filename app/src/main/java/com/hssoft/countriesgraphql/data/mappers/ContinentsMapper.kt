package com.hssoft.countriesgraphql.data.mappers

import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.entities.Country
import com.hssoft.countriesgraphql.domain.entities.Language
import com.hssoft.countriesgraphql.domain.extensions.emptyString
import hssoft.com.GetAllContinentsQuery

class ContinentsMapper {

    fun transform(continents: List<GetAllContinentsQuery.Continent>?) : List<Continent> {
        return continents?.map {
            Continent(code = it.code()?: emptyString(),
                name = it.name()?: emptyString(),
                countries = transformCountries(it.countries()))
        }?: listOf()
    }

    private fun transformCountries(countries: List<GetAllContinentsQuery.Country>?) : List<Country> {
        return countries?.map {
            Country(code = it.code()?: emptyString(),
                name = it.name()?: emptyString(),
                phone = it.phone(),
                currency = it.currency(),
                native = it.native_(),
                emoji = it.emoji(),
                languages = transformLanguages(it.languages()))
        }?: listOf()
    }

    private fun transformLanguages(languages: List<GetAllContinentsQuery.Language>?) : List<Language> {
        return languages?.map {
            Language(code = it.code()?: emptyString(),
                name = it.name()?: emptyString(),
                native = it.native_())
        }?: listOf()
    }
}