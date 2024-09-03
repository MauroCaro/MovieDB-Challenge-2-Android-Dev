package com.app.data.series.local

import androidx.room.Dao
import androidx.room.Query
import com.app.data.base.database.BaseDao
import com.app.data.series.model.SeriesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SeriesDao : BaseDao<SeriesEntity> {

    @Query("SELECT * FROM SeriesEntity")
    fun getAll(): Flow<List<SeriesEntity>>

    @Query("SELECT id FROM SeriesEntity")
    fun getAllId(): List<String>?

    @Query("SELECT * FROM SeriesEntity WHERE id = :id")
    fun getByIdFlow(id: String): Flow<SeriesEntity>

    @Query("DELETE FROM SeriesEntity")
    fun deleteAll(): Int

    @Query("DELETE FROM SeriesEntity where id = :id")
    fun delete(id: String): Int

    @Query("SELECT * FROM SeriesEntity WHERE id = :id")
    fun loadById(id: String): SeriesEntity?

}