package com.app.data.series.mapper

import com.app.data.base.mapper.MapperData
import com.app.data.series.model.SeriesEntity
import com.app.data.series.model.SeriesPojo
import javax.inject.Inject

class SeriesDataMapper @Inject constructor() : MapperData<SeriesEntity, SeriesPojo> {

    override fun mapRemote(remotePojo: SeriesPojo): SeriesEntity {
        return SeriesEntity(
            remotePojo.id,
            remotePojo.title,
            remotePojo.overview,
            "$IMAGE_URL${remotePojo.posterPath}",
            remotePojo.voteAverage,
            remotePojo.isForAdult,
            remotePojo.releaseDate,
            remotePojo.popularity
        )
    }

    companion object {
        private const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }
}