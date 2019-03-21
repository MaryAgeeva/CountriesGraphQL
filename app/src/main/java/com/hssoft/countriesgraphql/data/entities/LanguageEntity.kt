package com.hssoft.countriesgraphql.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.hssoft.countriesgraphql.domain.extensions.emptyString

@Entity(tableName = "languages", indices = [Index(value = ["title"], unique = true)])
class LanguageEntity(@PrimaryKey var code: String = emptyString(), var title: String = emptyString(),
                     var native: String? = emptyString())