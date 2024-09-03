package com.app.data.series.mapper

import com.app.data.base.mapper.MapperDomain
import com.app.data.series.model.SeriesEntity
import com.app.domain.series.model.Series
import javax.inject.Inject

class SeriesDomainMapper @Inject constructor() : MapperDomain<Series, SeriesEntity> {

    override fun mapRemote(entity: SeriesEntity): Series {
        return Series(
            entity.id,
            entity.title,
            entity.overview,
            entity.posterPath,
            entity.voteAverage,
            entity.isForAdult,
            entity.releaseDate,
            entity.popularity
        )
    }
}