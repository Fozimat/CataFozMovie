package com.fozimat.catafozmovie.data.source

import androidx.lifecycle.LiveData
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.vo.Resource

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<List<MoviesEntity>>>

    fun getAllTvShow(): LiveData<Resource<List<TvShowEntity>>>

    fun getDetailMovie(title: String): LiveData<Resource<MoviesEntity>>

    fun getDetailShow(title: String): LiveData<Resource<TvShowEntity>>

    fun getMoviesFav(): LiveData<List<MoviesEntity>>

    fun getTvShowFav(): LiveData<List<TvShowEntity>>

    fun setMoviesFav(movies: MoviesEntity, state: Boolean)

    fun setTvShowFav(movies: TvShowEntity, state: Boolean)
}