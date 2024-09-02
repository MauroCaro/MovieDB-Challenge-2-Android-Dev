package com.app.data.movies.mapper

import com.app.data.base.mapper.MapperData
import com.app.data.movies.model.MovieEntity
import com.app.data.movies.model.MoviePojo
import javax.inject.Inject

class MovieDataMapper @Inject constructor() : MapperData<MovieEntity, MoviePojo> {

    override fun mapRemote(remotePojo: MoviePojo): MovieEntity {
        return MovieEntity(
            remotePojo.id,
            remotePojo.title,
            remotePojo.overview,
            remotePojo.posterPath,
            remotePojo.voteAverage,
            remotePojo.isForAdult,
            remotePojo.releaseDate
        )

    }
}