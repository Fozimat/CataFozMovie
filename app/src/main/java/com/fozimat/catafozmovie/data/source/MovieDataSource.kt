package com.fozimat.catafozmovie.data.source

import androidx.lifecycle.LiveData
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.vo.Resource

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<List<MoviesEntity>>>

    fun getAllTvShow(): LiveData<Resource<List<MoviesEntity>>>

    fun getDetailMovie(title: String): LiveData<MoviesEntity>

    fun getDetailShow(title: String): LiveData<MoviesEntity>

    fun getMoviesFav(): LiveData<List<MoviesEntity>>

    fun getTvShowFav(): LiveData<List<MoviesEntity>>

    fun setMoviesFav(movies: MoviesEntity, state: Boolean)
}