package com.app.domain.series.uc

import com.app.domain.series.SeriesRepository
import com.app.domain.series.model.Series
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetAllSeriesUC @Inject constructor(
    private val seriesRepository: SeriesRepository
) {

    fun invoke(): Flow<List<Series>> {
        return seriesRepository.getAll()
    }

    suspend fun refresh() {
        seriesRepository.refresh()
    }
}