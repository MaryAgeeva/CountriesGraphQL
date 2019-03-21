package com.hssoft.countriesgraphql.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hssoft.countriesgraphql.domain.extensions.emptyString

@Entity(tableName = "countries")
class CountryEntity(@PrimaryKey var code: String = emptyString(), var name: String = emptyString(),
                    var phone: String? = emptyString(),
                    var currency: String? = emptyString(),
                    var native: String? = emptyString(),
                    var emoji: String? = emptyString())