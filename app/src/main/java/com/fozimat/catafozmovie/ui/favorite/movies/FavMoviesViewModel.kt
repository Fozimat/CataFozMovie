package com.fozimat.catafozmovie.ui.favorite.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity

class FavMoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getFavMovies(): LiveData<PagedList<MoviesEntity>> = movieRepository.getMoviesFav()
}