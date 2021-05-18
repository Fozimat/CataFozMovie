package com.fozimat.catafozmovie.ui.favorite.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavMoviesViewModelTest {

    private lateinit var viewModel: FavMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MoviesEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MoviesEntity>

    @Before
    fun setUp() {
        viewModel = FavMoviesViewModel(movieRepository)
    }

    @Test
    fun getFavMovies() {
        val movies = MutableLiveData<PagedList<MoviesEntity>>()
        movies.value = pagedList

        `when`(movieRepository.getMoviesFav()).thenReturn(movies)
        viewModel.getFavMovies().observeForever(observer)
        verify(observer).onChanged(pagedList)
    }
}