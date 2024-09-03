package com.app.data.series.local

import com.app.data.base.database.UpdateStorageOperation
import com.app.data.series.model.SeriesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SeriesLocalSourceImpl@Inject constructor(
    private val dao: SeriesDao
) : SeriesLocalSource {

    override fun getAll(): Flow<List<SeriesEntity>> {
        return dao.getAll().flowOn(Dispatchers.IO)
    }

    override fun getById(id: String): Flow<SeriesEntity?> {
        return dao.getByIdFlow(id).flowOn(Dispatchers.IO)
    }

    override fun createOrUpdate(items: List<SeriesEntity>): List<SeriesEntity> {
        return object : UpdateStorageOperation<SeriesEntity>() {
            override fun getAllIds(): List<String>? = dao.getAllId()

            override fun createOrUpdate(item: SeriesEntity) = dao.insert(items)

            override fun delete(id: String) {
                dao.delete(id)
            }
        }.execute(items)
    }

    override fun createOrUpdate(items: SeriesEntity): SeriesEntity {
        if (dao.update(items) == 0) {
            dao.insert(items)
        }
        return items
    }

    override fun deleteAll(): Int {
        return dao.deleteAll()
    }

    override fun deleteById(id: String): Int = dao.delete(id)


    override fun loadById(id: String): SeriesEntity? {
        return dao.loadById(id)
    }
}