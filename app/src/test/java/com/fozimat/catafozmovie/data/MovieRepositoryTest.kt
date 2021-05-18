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
import androidx.paging.DataSource
import com.fozimat.catafozmovie.vo.Resource
import com.fozimat.utils.PagedListUtil


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
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShow()).thenReturn(dataSourceFactory)
        movieRepository.getAllTvShow()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShow()))
        verify(local).getTvShow()
        assertNotNull(movieEntities.data)
        assertEquals(tvShowResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyMovies = MutableLiveData<MoviesEntity>()
        dummyMovies.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getDetailMovie(titleMovie)).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(titleMovie))
        verify(local).getDetailMovie(titleMovie)
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
        val dummyShow = MutableLiveData<TvShowEntity>()
        dummyShow.value = DataDummy.generateTvShow()[0]
        `when`(local.getDetailTvShow(titleShow)).thenReturn(dummyShow)

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailShow(titleShow))
        verify(local).getDetailTvShow(titleShow)
        val response = tvShowResponse[0]
        assertNotNull(movieEntities)
        assertEquals(response.title, movieEntities.data?.title)
        assertEquals(response.year, movieEntities.data?.year)
        assertEquals(response.genre, movieEntities.data?.genre)
        assertEquals(response.description, movieEntities.data?.description)
        assertEquals(response.duration, movieEntities.data?.duration)
        assertEquals(response.image, movieEntities.data?.image)
    }

    @Test
    fun getMoviesFav() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getMoviesFav()).thenReturn(dataSourceFactory)
        movieRepository.getMoviesFav()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMoviesFav()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShowFav()).thenReturn(dataSourceFactory)
        movieRepository.getTvShowFav()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShow()))
        verify(local).getTvShowFav()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }
}