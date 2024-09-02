package com.app.data.movies.local

import com.app.data.base.database.UpdateStorageOperation
import com.app.data.movies.model.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieLocalSourceImpl @Inject constructor(
    private val dao: MovieDao
) : MovieLocalSource {

    override fun getAll(): Flow<List<MovieEntity>> {
        return dao.getAll().flowOn(Dispatchers.IO)
    }

    override fun getById(id: String): Flow<MovieEntity?> {
        return dao.getByIdFlow(id).flowOn(Dispatchers.IO)
    }

    override fun createOrUpdate(items: List<MovieEntity>): List<MovieEntity> {
        return object : UpdateStorageOperation<MovieEntity>() {
            override fun getAllIds(): List<String>? = dao.getAllId()

            override fun createOrUpdate(item: MovieEntity) = dao.insert(items)

            override fun delete(id: String) {
                dao.delete(id)
            }
        }.execute(items)
    }

    override fun createOrUpdate(items: MovieEntity): MovieEntity {
        if (dao.update(items) == 0) {
            dao.insert(items)
        }
        return items
    }

    override fun deleteAll(): Int {
        return dao.deleteAll()
    }

    override fun deleteById(id: String): Int = dao.delete(id)


    override fun loadById(id: String): MovieEntity? {
        return dao.loadById(id)
    }
}