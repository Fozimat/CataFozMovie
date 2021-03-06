package com.fozimat.catafozmovie.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.utils.DataDummy
import com.fozimat.catafozmovie.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyShow = DataDummy.generateTvShow()[0]
    private val titleMovie = dummyMovie.title
    private val titleShow = dummyShow.title

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MoviesEntity>>

    @Mock
    private lateinit var showObserver: Observer<Resource<TvShowEntity>>


    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelectedMovie(titleMovie)
        viewModel.setSelectedTvShow(titleShow)
    }

    @Test
    fun getMovieDetail() {
        val dummyMovies = Resource.success(dummyMovie)
        val movies = MutableLiveData<Resource<MoviesEntity>>()
        movies.value = dummyMovies

        `when`(movieRepository.getDetailMovie(titleMovie)).thenReturn(movies)
        viewModel.movie = movieRepository.getDetailMovie(titleMovie)
        val movieEntity = viewModel.movie.value
        verify(movieRepository).getDetailMovie(titleMovie)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.title, movieEntity?.data?.title)
        assertEquals(dummyMovie.year, movieEntity?.data?.year)
        assertEquals(dummyMovie.genre, movieEntity?.data?.genre)
        assertEquals(dummyMovie.description, movieEntity?.data?.description)
        assertEquals(dummyMovie.duration, movieEntity?.data?.duration)
        assertEquals(dummyMovie.image, movieEntity?.data?.image)

        viewModel.movie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getTvShowDetail() {
        val dummyShows = Resource.success(dummyShow)
        val movies = MutableLiveData<Resource<TvShowEntity>>()
        movies.value = dummyShows

        `when`(movieRepository.getDetailShow(titleShow)).thenReturn(movies)
        viewModel.tvShow = movieRepository.getDetailShow(titleShow)
        val movieEntity = viewModel.tvShow.value
        verify(movieRepository).getDetailShow(titleShow)
        assertNotNull(movieEntity)
        assertEquals(dummyShow.title, movieEntity?.data?.title)
        assertEquals(dummyShow.year, movieEntity?.data?.year)
        assertEquals(dummyShow.genre, movieEntity?.data?.genre)
        assertEquals(dummyShow.description, movieEntity?.data?.description)
        assertEquals(dummyShow.duration, movieEntity?.data?.duration)
        assertEquals(dummyShow.image, movieEntity?.data?.image)

        viewModel.tvShow.observeForever(showObserver)
        verify(showObserver).onChanged(dummyShows)
    }

    @Test
    fun setMovieFav() {
        val dummyMovies = Resource.success(dummyMovie.copy(favorited = false))
        val movies = MutableLiveData<Resource<MoviesEntity>>()
        movies.value = dummyMovies

        `when`(movieRepository.getDetailMovie(titleMovie)).thenReturn(movies)
        viewModel.movie = movieRepository.getDetailMovie(titleMovie)
        viewModel.setFavorite()
        verify(movieRepository).setMoviesFav(movies.value?.data as MoviesEntity, true)
        verifyNoMoreInteractions(movieObserver)
    }

    @Test
    fun setTvShowFav() {
        val dummyShow = Resource.success(dummyShow.copy(favorited = false))
        val movies = MutableLiveData<Resource<TvShowEntity>>()
        movies.value = dummyShow

        `when`(movieRepository.getDetailShow(titleShow)).thenReturn(movies)
        viewModel.tvShow = movieRepository.getDetailShow(titleShow)
        viewModel.setFavorite()
        verify(movieRepository).setTvShowFav(movies.value?.data as TvShowEntity, true)
        verifyNoMoreInteractions(showObserver)
    }

    @Test
    fun deleteMovieFav() {
        val dummyMovies = Resource.success(dummyMovie.copy(favorited = true))
        val movies = MutableLiveData<Resource<MoviesEntity>>()
        movies.value = dummyMovies

        `when`(movieRepository.getDetailMovie(titleMovie)).thenReturn(movies)
        viewModel.movie = movieRepository.getDetailMovie(titleMovie)
        viewModel.setFavorite()
        verify(movieRepository).setMoviesFav(movies.value?.data as MoviesEntity, false)
        verifyNoMoreInteractions(movieObserver)
    }

    @Test
    fun deleteTvShowFav() {
        val dummyShow = Resource.success(dummyShow.copy(favorited = true))
        val movies = MutableLiveData<Resource<TvShowEntity>>()
        movies.value = dummyShow

        `when`(movieRepository.getDetailShow(titleShow)).thenReturn(movies)
        viewModel.tvShow = movieRepository.getDetailShow(titleShow)
        viewModel.setFavorite()
        verify(movieRepository).setTvShowFav(movies.value?.data as TvShowEntity, false)
        verifyNoMoreInteractions(showObserver)
    }
}