package com.fozimat.catafozmovie.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.vo.Resource

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MoviesEntity>>>

    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailMovie(title: String): LiveData<Resource<MoviesEntity>>

    fun getDetailShow(title: String): LiveData<Resource<TvShowEntity>>

    fun getMoviesFav(): LiveData<PagedList<MoviesEntity>>

    fun getTvShowFav(): LiveData<PagedList<TvShowEntity>>

    fun setMoviesFav(movies: MoviesEntity, state: Boolean)

    fun setTvShowFav(movies: TvShowEntity, state: Boolean)
}