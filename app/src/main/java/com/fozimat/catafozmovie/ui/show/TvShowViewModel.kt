package com.fozimat.catafozmovie.ui.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.vo.Resource

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<List<MoviesEntity>>> = movieRepository.getAllTvShow()
}