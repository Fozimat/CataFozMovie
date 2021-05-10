package com.fozimat.catafozmovie.ui.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.MoviesEntity

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MoviesEntity>> = movieRepository.getAllTvShow()
}