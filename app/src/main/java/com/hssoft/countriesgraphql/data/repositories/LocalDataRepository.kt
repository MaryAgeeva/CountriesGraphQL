package com.hssoft.countriesgraphql.data.repositories

import android.content.Context
import androidx.room.Room
import com.hssoft.countriesgraphql.data.db.ContinentsDB
import com.hssoft.countriesgraphql.data.mappers.DBMapper
import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.repositories.LocalData
import io.reactivex.Single

class LocalDataRepository(context: Context, private val dbMapper: DBMapper) : LocalData {

    private val db: ContinentsDB

    init {
        db = Room.databaseBuilder(context, ContinentsDB::class.java, DB_TITLE).allowMainThreadQueries().build()
    }

    override fun getContinents(): Single<List<Continent>> {
        return Single.create {
            val continents = db.continentsDao.getAllContinentsRelation()
            val countries = db.countiresDao.getAllCountriesRelation()
            val languages = db.languagesDao.allLanguages
            it.onSuccess(dbMapper.transformContinents(continents, countries, languages))
        }
    }

    override fun getContinent(title: String): Single<Continent> {
        return Single.create {
            val continent = db.continentsDao.getContinentRelationById(title)
            val countries = db.countiresDao.getCountriesRelationById(title)
            val languages = db.languagesDao.allLanguages
            it.onSuccess(dbMapper.transformContinent(continent, countries, languages))
        }
    }

    override fun isNotEmpty(): Boolean = db.continentsDao.allContinents.isNotEmpty()

    override fun insertContinents(continents: List<Continent>) {
        val result = dbMapper.transformContinentsDBGeneral(continents)
        db.continentsDao.insertAll(result.continents)
        db.countiresDao.insertAll(result.countries)
        db.languagesDao.insertAll(result.languages)
        db.continentsDao.insertRelations(result.continentsToCountries)
        db.countiresDao.insertRelations(result.countriesToLanguages)
    }

    private companion object {
        const val DB_TITLE = "continents_db"
    }
}