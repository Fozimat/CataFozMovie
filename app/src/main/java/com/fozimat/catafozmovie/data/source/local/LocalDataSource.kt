package com.fozimat.catafozmovie.data.source.local

import androidx.lifecycle.LiveData
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.room.MoviesDao

class LocalDataSource private constructor(private val mMoviesDao: MoviesDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(moviesDao: MoviesDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(moviesDao)
    }

    fun getMovies(): LiveData<List<MoviesEntity>> = mMoviesDao.getMovies()

    fun getTvShow(): LiveData<List<MoviesEntity>> = mMoviesDao.getTvShow()

    fun getDetailMovie(title: String): LiveData<MoviesEntity> = mMoviesDao.getDetailMovie(title)

    fun getDetailTvShow(title:String): LiveData<MoviesEntity> = mMoviesDao.getDetailTvShow(title)

    fun getMoviesFav(): LiveData<List<MoviesEntity>> = mMoviesDao.getMoviesFav()

    fun getTvShowFav(): LiveData<List<MoviesEntity>> = mMoviesDao.getTvShowFav()

    fun insertMovies(movies: List<MoviesEntity>) = mMoviesDao.insertMovies(movies)

    fun setMoviesFav(movies: MoviesEntity, newState: Boolean) {
        movies.favorited = newState
        mMoviesDao.updateMovies(movies)
    }
}