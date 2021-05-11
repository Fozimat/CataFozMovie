package com.fozimat.catafozmovie.ui.show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.MoviesEntity
import com.fozimat.catafozmovie.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MoviesEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateTvShow()
        val movies = MutableLiveData<List<MoviesEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(movieRepository.getAllTvShow()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value
        Mockito.verify(movieRepository).getAllTvShow()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}