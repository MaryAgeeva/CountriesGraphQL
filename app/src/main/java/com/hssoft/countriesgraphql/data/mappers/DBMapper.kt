package com.hssoft.countriesgraphql.data.mappers

import com.hssoft.countriesgraphql.data.entities.*
import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.entities.Country
import com.hssoft.countriesgraphql.domain.entities.Language

class DBMapper {

    fun transformContinentsDBGeneral(continents: List<Continent>?) : GeneralDBResponse {
        val generalResponse = GeneralDBResponse()
        continents?.forEach { continent ->
            generalResponse.continents.add(ContinentEntity(continent.code, continent.name))
            continent.countries.forEach { country ->
                generalResponse.continentsToCountries.add(CountriesToContinents(country.code, continent.code))
                generalResponse.countries.add(
                    CountryEntity(country.code, country.name, country.phone, country.currency, country.native, country.emoji))
                country.languages.forEach {
                    generalResponse.countriesToLanguages.add(CountriesToLanguages(country.code, it.code))
                    generalResponse.languages.add(LanguageEntity(it.code, it.name, it.native))
                }
            }
        }
        return generalResponse
    }

    fun transformContinents(continents: List<ContinentsRelationsObject>?, countries: List<CountriesRelationsObject>?,
                            languages: List<LanguageEntity>) : List<Continent> {
        return continents?.map { continentDB ->
            transformContinent(continentDB, countries?.filter { continentDB.countriesIds.contains(it.country.code) },
                languages)
        }?: listOf()
    }

    fun transformContinent(continentDB: ContinentsRelationsObject, countries: List<CountriesRelationsObject>?,
                           languages: List<LanguageEntity>) : Continent {
        val continent = Continent(continentDB.continent.code, continentDB.continent.title)
        continent.countries = countries?.map { country ->
            Country(country.country.code, country.country.name, country.country.phone,
            country.country.currency, country.country.native, country.country.emoji,
            languages.filter { country.langIds.contains(it.code) }.map {
                Language(it.code, it.title, it.native)
            }
        ) }?: listOf()
        return continent
    }

    class GeneralDBResponse(val continents: MutableList<ContinentEntity> = mutableListOf(),
                            val countries: MutableList<CountryEntity> = mutableListOf(),
                            val languages: MutableList<LanguageEntity> = mutableListOf(),
                            val continentsToCountries: MutableList<CountriesToContinents> = mutableListOf(),
                            val countriesToLanguages: MutableList<CountriesToLanguages> = mutableListOf())
}