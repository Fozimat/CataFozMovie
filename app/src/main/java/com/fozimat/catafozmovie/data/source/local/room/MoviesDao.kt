package com.fozimat.catafozmovie.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_entities WHERE isTvShow = 0")
    fun getMovies(): LiveData<List<MoviesEntity>>

    @Query("SELECT * FROM tv_show_entities WHERE isTvShow = 1")
    fun getTvShow(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM movies_entities WHERE title = :title AND isTvShow = 0")
    fun getDetailMovie(title: String): LiveData<MoviesEntity>

    @Query("SELECT * FROM tv_show_entities WHERE title = :title AND isTvShow = 1")
    fun getDetailTvShow(title: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM movies_entities WHERE isTvShow = 0 AND favorited = 1")
    fun getMoviesFav(): LiveData<List<MoviesEntity>>

    @Query("SELECT * FROM tv_show_entities WHERE isTvShow = 1 AND favorited = 1")
    fun getTvShowFav(): LiveData<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MoviesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(movies: List<TvShowEntity>)

    @Update
    fun updateMovies(movies: MoviesEntity)

    @Update
    fun updateTvShow(movies: TvShowEntity)

}