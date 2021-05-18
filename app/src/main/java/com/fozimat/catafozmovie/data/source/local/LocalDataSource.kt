package com.fozimat.catafozmovie.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.data.source.local.room.MoviesDao

class LocalDataSource private constructor(private val mMoviesDao: MoviesDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(moviesDao: MoviesDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(moviesDao)
    }

    fun getMovies(): DataSource.Factory<Int, MoviesEntity> = mMoviesDao.getMovies()

    fun getTvShow(): DataSource.Factory<Int, TvShowEntity> = mMoviesDao.getTvShow()

    fun getDetailMovie(title: String): LiveData<MoviesEntity> = mMoviesDao.getDetailMovie(title)

    fun getDetailTvShow(title:String): LiveData<TvShowEntity> = mMoviesDao.getDetailTvShow(title)

    fun getMoviesFav(): DataSource.Factory<Int, MoviesEntity> = mMoviesDao.getMoviesFav()

    fun getTvShowFav(): DataSource.Factory<Int, TvShowEntity> = mMoviesDao.getTvShowFav()

    fun insertMovies(movies: List<MoviesEntity>) = mMoviesDao.insertMovies(movies)

    fun insertTvShow(movies: List<TvShowEntity>) = mMoviesDao.insertTvShow(movies)

    fun setMoviesFav(movies: MoviesEntity, newState: Boolean) {
        movies.favorited = newState
        mMoviesDao.updateMovies(movies)
    }

    fun setTvShowFav(movies: TvShowEntity, newState: Boolean){
        movies.favorited = newState
        mMoviesDao.updateTvShow(movies)
    }
}