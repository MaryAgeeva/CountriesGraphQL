package com.hssoft.countriesgraphql.domain.repositories

import com.hssoft.countriesgraphql.domain.entities.Continent
import io.reactivex.Single

interface LocalData {
    fun getContinents() : Single<List<Continent>>
    fun getContinent(title: String) : Single<Continent>
    fun insertContinents(continents: List<Continent>)
    fun isNotEmpty() : Boolean
}