package com.hssoft.countriesgraphql.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hssoft.countriesgraphql.data.entities.*

@Database(entities = [ContinentEntity::class, CountryEntity::class, LanguageEntity::class, CountriesToContinents::class,
                    CountriesToLanguages::class], version = 1)
abstract class ContinentsDB : RoomDatabase() {
    abstract val continentsDao: ContinentsDao
    abstract val countiresDao: CountriesDao
    abstract val languagesDao: LanguagesDao
}