package com.fozimat.catafozmovie.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.fozimat.catafozmovie.data.source.local.LocalDataSource
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.data.source.remote.RemoteDataSource
import com.fozimat.catafozmovie.utils.AppExecutors
import com.fozimat.catafozmovie.utils.DataDummy
import com.fozimat.catafozmovie.utils.LiveDataTestUtil
import com.fozimat.catafozmovie.vo.Resource
import com.fozimat.utils.PagedListUtil
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
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
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShow()).thenReturn(dataSourceFactory)
        movieRepository.getAllTvShow()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShow()))
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
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getMoviesFav()).thenReturn(dataSourceFactory)
        movieRepository.getMoviesFav()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMoviesFav()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShowFav()).thenReturn(dataSourceFactory)
        movieRepository.getTvShowFav()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShow()))
        verify(local).getTvShowFav()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun setMoviesFav() {
        val movie = MoviesEntity(
            "Alita: Battle Angel",
            2019,
            "Action, Fantasy, Adventure",
            "When Alita awakens with no memories of who she is in a future world she doesn't know, she is captured by Ido, a compassionate doctor who realizes that somewhere in the shell of this abandoned cyborg is the heart and soul of an extraordinary young woman",
            "2h 2m",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/quWP5VIzTUf0Hr8AJZLloM6js8I.jpg",
            false,
            isTvShow = false
        )
        local.setMoviesFav(movie, true)
        verify(local).setMoviesFav(movie, true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun setMoviesTvShowFav() {
        val movie = TvShowEntity(
            "Arrow",
            2012,
            "Crime, Drama, Mystery, Action",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "42m",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            false,
            isTvShow = true
        )
        local.setTvShowFav(movie, true)
        verify(local).setTvShowFav(movie, true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun deleteMoviesFav() {
        val movie = MoviesEntity(
            "Alita: Battle Angel",
            2019,
            "Action, Fantasy, Adventure",
            "When Alita awakens with no memories of who she is in a future world she doesn't know, she is captured by Ido, a compassionate doctor who realizes that somewhere in the shell of this abandoned cyborg is the heart and soul of an extraordinary young woman",
            "2h 2m",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/quWP5VIzTUf0Hr8AJZLloM6js8I.jpg",
            true,
            isTvShow = false
        )
        local.setMoviesFav(movie, false)
        verify(local).setMoviesFav(movie, false)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun deleteTvShowFav() {
        val movie = TvShowEntity(
            "Arrow",
            2012,
            "Crime, Drama, Mystery, Action",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "42m",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            true,
            isTvShow = true
        )
        local.setTvShowFav(movie, false)
        verify(local).setTvShowFav(movie, false)
        verifyNoMoreInteractions(local)
    }
}