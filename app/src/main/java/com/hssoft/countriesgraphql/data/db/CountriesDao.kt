package com.hssoft.countriesgraphql.data.db

import androidx.room.*
import com.hssoft.countriesgraphql.data.entities.CountriesRelationsObject
import com.hssoft.countriesgraphql.data.entities.CountriesToLanguages
import com.hssoft.countriesgraphql.data.entities.CountryEntity

@Dao
interface CountriesDao : BaseDao<CountryEntity> {

    @get:Query("SELECT * FROM countries")
    val allCountries: List<CountryEntity>

    @Transaction
    @Query("SELECT * FROM countries")
    fun getAllCountriesRelation(): List<CountriesRelationsObject>

    @Transaction
    @Query("SELECT * FROM countries INNER JOIN countries_to_continents ON countries.code = countries_to_continents.country_id WHERE countries_to_continents.continent_id = :code")
    fun getCountriesRelationById(code: String): List<CountriesRelationsObject>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRelations(items: List<CountriesToLanguages>)
}