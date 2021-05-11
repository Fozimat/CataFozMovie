package com.fozimat.catafozmovie.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.MoviesEntity
import com.fozimat.catafozmovie.utils.DataDummy
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MoviesEntity>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<MoviesEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(movieRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value
        Mockito.verify(movieRepository).getAllMovies()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(10, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}