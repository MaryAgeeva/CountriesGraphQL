package com.hssoft.countriesgraphql.data.entities

import androidx.room.Embedded
import androidx.room.Relation

class ContinentsRelationsObject(@Embedded var continent : ContinentEntity = ContinentEntity()) {
    @Relation(
        parentColumn = "code",
        entity = CountriesToContinents::class,
        entityColumn = "continent_id",
        projection = ["country_id"]
    ) var countriesIds: List<String> = listOf()
}

class CountriesRelationsObject(@Embedded var country : CountryEntity = CountryEntity()) {
    @Relation(
        parentColumn = "code",
        entity = CountriesToLanguages::class,
        entityColumn = "country_id",
        projection = ["language_id"]
    ) var langIds: List<String> = listOf()
}
