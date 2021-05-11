package com.fozimat.catafozmovie.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fozimat.catafozmovie.data.source.remote.RemoteDataSource
import com.fozimat.catafozmovie.utils.DataDummy
import com.fozimat.catafozmovie.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()

    private val titleMovie = movieResponse[0].title
    private val titleShow = tvShowResponse[0].title

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallBack)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllMovies())
        Mockito.verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowCallBack)
                .onAllShowReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShow(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllTvShow())
        Mockito.verify(remote).getAllTvShow(any())
        assertNotNull(movieEntities)
        assertEquals(tvShowResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallBack)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(titleMovie))
        Mockito.verify(remote).getAllMovies(any())
        val response = movieResponse[0]
        assertNotNull(movieEntities)
        assertEquals(response.title, movieEntities.title)
        assertEquals(response.year, movieEntities.year)
        assertEquals(response.genre, movieEntities.genre)
        assertEquals(response.description, movieEntities.description)
        assertEquals(response.duration, movieEntities.duration)
        assertEquals(response.image, movieEntities.image)
    }

    @Test
    fun getDetailShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadShowCallBack)
                .onAllShowReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShow(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDetailShow(titleShow))
        Mockito.verify(remote).getAllTvShow(any())
        val response = tvShowResponse[0]
        assertNotNull(movieEntities)
        assertEquals(response.title, movieEntities.title)
        assertEquals(response.year, movieEntities.year)
        assertEquals(response.genre, movieEntities.genre)
        assertEquals(response.description, movieEntities.description)
        assertEquals(response.duration, movieEntities.duration)
        assertEquals(response.image, movieEntities.image)
    }
}