package com.fozimat.catafozmovie.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.MoviesEntity
import com.fozimat.catafozmovie.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyShow = DataDummy.generateTvShow()[0]
    private val title = dummyMovie.title

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<MoviesEntity>


    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelectedMovie(title)
    }

    @Test
    fun getMovie() {
        val movies = MutableLiveData<MoviesEntity>()
        movies.value = dummyMovie

        Mockito.`when`(movieRepository.getDetailMovie(title)).thenReturn(movies)
        val movieEntity = viewModel.getDetailMovie().value as MoviesEntity
        verify(movieRepository).getDetailMovie(title)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.year, movieEntity.year)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.image, movieEntity.image)

        viewModel.getDetailMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val movies = MutableLiveData<MoviesEntity>()
        movies.value = dummyShow

        Mockito.`when`(movieRepository.getDetailShow(title)).thenReturn(movies)
        val movieEntity = viewModel.getDetailShow().value as MoviesEntity
        verify(movieRepository).getDetailShow(title)
        assertNotNull(movieEntity)
        assertEquals(dummyShow.title, movieEntity.title)
        assertEquals(dummyShow.year, movieEntity.year)
        assertEquals(dummyShow.genre, movieEntity.genre)
        assertEquals(dummyShow.description, movieEntity.description)
        assertEquals(dummyShow.duration, movieEntity.duration)
        assertEquals(dummyShow.image, movieEntity.image)

        viewModel.getDetailShow().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyShow)
    }
}