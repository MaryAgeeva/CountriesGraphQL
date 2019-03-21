package com.hssoft.countriesgraphql.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hssoft.countriesgraphql.domain.extensions.emptyString

@Entity(tableName = "continents")
class ContinentEntity(@PrimaryKey var code: String = emptyString(), var title: String = emptyString())