package com.hssoft.countriesgraphql.data.db

import androidx.room.*
import com.hssoft.countriesgraphql.data.entities.ContinentEntity
import com.hssoft.countriesgraphql.data.entities.ContinentsRelationsObject
import com.hssoft.countriesgraphql.data.entities.CountriesToContinents

@Dao
interface ContinentsDao : BaseDao<ContinentEntity> {

    @get:Query("SELECT * FROM continents")
    val allContinents: List<ContinentEntity>

    @Transaction
    @Query("SELECT * FROM continents")
    fun getAllContinentsRelation(): List<ContinentsRelationsObject>

    @Transaction
    @Query("SELECT * FROM continents WHERE code = :code")
    fun getContinentRelationById(code: String): ContinentsRelationsObject

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRelations(items: List<CountriesToContinents>)
}