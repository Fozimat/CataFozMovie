package com.fozimat.catafozmovie.data.source

import androidx.lifecycle.LiveData
import com.fozimat.catafozmovie.data.MoviesEntity

interface MovieDataSource {
    fun getAllMovies(): LiveData<List<MoviesEntity>>

    fun getAllTvShow(): LiveData<List<MoviesEntity>>

    fun getDetailMovie(title: String): LiveData<MoviesEntity>

    fun getDetailShow(title: String): LiveData<MoviesEntity>
}