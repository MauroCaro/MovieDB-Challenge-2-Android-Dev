package com.app.domain.movies

import com.app.domain.movies.model.Movie
import com.app.domain.movies.uc.GetAllMoviesUC
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetAllMoviesUCTest {

    private val movieRepository = mockk<MovieRepository>()
    private lateinit var getAllMoviesUC: GetAllMoviesUC

    @Before
    fun setUp() {
        getAllMoviesUC = GetAllMoviesUC(movieRepository)
    }

    @Test
    fun `invoke should return flow of movies`() = runBlocking {
        val movieList = listOf(
            Movie(id = "1", title = "Inception", overview = "A mind-bending thriller", posterPath = "path/to/poster", voteAverage = 8.8, isForAdult = false, releaseDate = "2010-07-16"),
            Movie(id = "2", title = "The Matrix", overview = "A hacker discovers reality is a simulation", posterPath = "path/to/poster2", voteAverage = 8.7, isForAdult = false, releaseDate = "1999-03-31")
        )
        coEvery { movieRepository.getAll() } returns flowOf(movieList)

        val result: Flow<List<Movie>> = getAllMoviesUC.invoke()

        result.collect { movies ->
            assertEquals(movieList, movies)
        }

        coVerify(exactly = 1) { movieRepository.getAll() }
    }

    @Test
    fun `refresh should call refresh on repository`() = runBlocking {
        coEvery { movieRepository.refresh() } returns Unit

        getAllMoviesUC.refresh()

        coVerify(exactly = 1) { movieRepository.refresh() }
    }
}