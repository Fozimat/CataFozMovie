package com.fozimat.catafozmovie.ui.favorite.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity

class FavShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getShowMovies(): LiveData<PagedList<TvShowEntity>> = movieRepository.getTvShowFav()
}