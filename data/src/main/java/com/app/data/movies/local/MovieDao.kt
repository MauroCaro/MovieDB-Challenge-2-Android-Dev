package com.app.data.movies.local

import androidx.room.Dao
import androidx.room.Query
import com.app.data.base.database.BaseDao
import com.app.data.movies.model.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao : BaseDao<MovieEntity> {

    @Query("SELECT * FROM MovieEntity")
    fun getAll(): Flow<List<MovieEntity>>

    @Query("SELECT id FROM MovieEntity")
    fun getAllId(): List<String>?

    @Query("SELECT * FROM MovieEntity WHERE id = :id")
    fun getByIdFlow(id: String): Flow<MovieEntity>

    @Query("DELETE FROM MovieEntity")
    fun deleteAll(): Int

    @Query("DELETE FROM MovieEntity where id = :id")
    fun delete(id: String): Int

    @Query("SELECT * FROM MovieEntity WHERE id = :id")
    fun loadById(id: String): MovieEntity?

}