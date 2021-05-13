package com.fozimat.catafozmovie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private lateinit var title: String

    fun setSelectedMovie(title: String) {
        this.title = title
    }

    fun getDetailMovie(): LiveData<MoviesEntity> = movieRepository.getDetailMovie(title)

    fun getDetailShow(): LiveData<MoviesEntity> = movieRepository.getDetailShow(title)
}