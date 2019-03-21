package com.hssoft.countriesgraphql.data.entities

import androidx.room.*
import com.hssoft.countriesgraphql.domain.extensions.emptyString

@Entity(tableName = "countries_to_continents",
        primaryKeys = ["country_id", "continent_id"], foreignKeys = [
        ForeignKey(entity = ContinentEntity::class, parentColumns = ["code"],
            childColumns = ["continent_id"]),
        ForeignKey(entity = CountryEntity::class, parentColumns = ["code"],
            childColumns = ["country_id"])])
class CountriesToContinents(@ColumnInfo(name = "country_id") var countryId: String = emptyString(),
                            @ColumnInfo(name = "continent_id") var continentId: String = emptyString())