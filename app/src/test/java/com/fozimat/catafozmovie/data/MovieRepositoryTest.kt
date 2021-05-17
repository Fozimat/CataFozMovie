package com.fozimat.catafozmovie.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.fozimat.catafozmovie.data.source.local.LocalDataSource
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.data.source.remote.RemoteDataSource
import com.fozimat.catafozmovie.utils.AppExecutors
import com.fozimat.catafozmovie.utils.DataDummy
import com.fozimat.catafozmovie.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()

    private val titleMovie = movieResponse[0].title
    private val titleShow = tvShowResponse[0].title

    @Test
    fun getAllMovies() {
        val dummyMovies = MutableLiveData<List<MoviesEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllMovies())
        verify(local).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllShow() {
        val dummyShow = MutableLiveData<List<TvShowEntity>>()
        dummyShow.value = DataDummy.generateTvShow()
        `when`(local.getTvShow()).thenReturn(dummyShow)

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllTvShow())
        verify(local).getTvShow()
        assertNotNull(movieEntities.data)
        assertEquals(tvShowResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyMovies = MutableLiveData<List<MoviesEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(titleMovie))
        verify(local).getMovies()
        val response = movieResponse[0]
        assertNotNull(movieEntities)
        assertEquals(response.title, movieEntities.data?.title)
        assertEquals(response.year, movieEntities.data?.year)
        assertEquals(response.genre, movieEntities.data?.genre)
        assertEquals(response.description, movieEntities.data?.description)
        assertEquals(response.duration, movieEntities.data?.duration)
        assertEquals(response.image, movieEntities.data?.image)
    }

    @Test
    fun getDetailShow() {
        val dummyShow = MutableLiveData<List<TvShowEntity>>()
        dummyShow.value = DataDummy.generateTvShow()
        `when`(local.getTvShow()).thenReturn(dummyShow)

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailShow(titleShow))
        verify(local).getTvShow()
        val response = tvShowResponse[0]
        assertNotNull(movieEntities)
        assertEquals(response.title, movieEntities.data?.title)
        assertEquals(response.year, movieEntities.data?.year)
        assertEquals(response.genre, movieEntities.data?.genre)
        assertEquals(response.description, movieEntities.data?.description)
        assertEquals(response.duration, movieEntities.data?.duration)
        assertEquals(response.image, movieEntities.data?.image)
    }
}