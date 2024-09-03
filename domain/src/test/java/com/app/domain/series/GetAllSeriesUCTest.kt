package com.app.domain.series

import com.app.domain.series.model.Series
import com.app.domain.series.uc.GetAllSeriesUC
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetAllSeriesUCTest {

    private lateinit var getAllSeriesUC: GetAllSeriesUC
    private val seriesRepository = mockk<SeriesRepository>(relaxed = true)

    @Before
    fun setup() {
        getAllSeriesUC = GetAllSeriesUC(seriesRepository)
    }

    @Test
    fun `invoke calls seriesRepository getAll`() = runBlocking {
        val expectedSeries = listOf(
            Series(id = "1", title = "Test Series", overview = "Overview", posterPath = "path", voteAverage = 8.0, isForAdult = false, releaseDate = "2024-01-01", popularity = 10.0)
        )
        coEvery { seriesRepository.getAll() } returns flowOf(expectedSeries)
        val actualSeries = getAllSeriesUC.invoke().first()
        assertEquals(expectedSeries, actualSeries)
        coVerify { seriesRepository.getAll() }
    }

    @Test
    fun `refresh calls seriesRepository refresh`() = runBlocking {
        getAllSeriesUC.refresh()
        coVerify { seriesRepository.refresh() }
    }
}