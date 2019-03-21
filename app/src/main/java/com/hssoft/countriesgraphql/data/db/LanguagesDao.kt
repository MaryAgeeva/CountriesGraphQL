package com.hssoft.countriesgraphql.data.db

import androidx.room.Dao
import androidx.room.Query
import com.hssoft.countriesgraphql.data.entities.LanguageEntity

@Dao
interface LanguagesDao : BaseDao<LanguageEntity> {

    @get:Query("SELECT * FROM languages")
    val allLanguages: List<LanguageEntity>
}