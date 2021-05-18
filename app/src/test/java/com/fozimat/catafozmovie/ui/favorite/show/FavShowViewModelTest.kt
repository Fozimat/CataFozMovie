package com.fozimat.catafozmovie.ui.favorite.show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavShowViewModelTest {

    private lateinit var viewModel: FavShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavShowViewModel(movieRepository)
    }

    @Test
    fun getTvShow() {
        val movies = MutableLiveData<PagedList<TvShowEntity>>()
        movies.value = pagedList

        Mockito.`when`(movieRepository.getTvShowFav()).thenReturn(movies)
        viewModel.getShowMovies().observeForever(observer)
        verify(observer).onChanged(pagedList)
    }
}