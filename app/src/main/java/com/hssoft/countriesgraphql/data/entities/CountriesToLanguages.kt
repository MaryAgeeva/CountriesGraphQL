package com.hssoft.countriesgraphql.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.hssoft.countriesgraphql.domain.extensions.emptyString

@Entity(tableName = "countries_to_languages",
        primaryKeys = ["country_id", "language_id"])
class CountriesToLanguages(@ColumnInfo(name = "country_id") var countryId: String = emptyString(),
                           @ColumnInfo(name = "language_id") var languageId: String = emptyString())