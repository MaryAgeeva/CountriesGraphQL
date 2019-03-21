package com.hssoft.countriesgraphql.data.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(item: List<T>): List<Long>

    @Update
    fun update(item: T)

    @Update
    fun updateAll(items: List<T>)
}