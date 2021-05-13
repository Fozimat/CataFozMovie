package com.fozimat.catafozmovie.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_entities WHERE isTvShow = 0 AND favorited = 0")
    fun getMovies(): LiveData<List<MoviesEntity>>

    @Query("SELECT * FROM movies_entities WHERE isTvShow = 1 AND favorited = 0")
    fun getTvShow(): LiveData<List<MoviesEntity>>

    @Query("SELECT * FROM movies_entities WHERE title = :title AND isTvShow = 0")
    fun getDetailMovie(title: String): LiveData<MoviesEntity>

    @Query("SELECT * FROM movies_entities WHERE title = :title AND isTvShow = 1")
    fun getDetailTvShow(title: String): LiveData<MoviesEntity>

    @Query("SELECT * FROM movies_entities WHERE isTvShow = 0 AND favorited = 1")
    fun getMoviesFav(): LiveData<List<MoviesEntity>>

    @Query("SELECT * FROM movies_entities WHERE isTvShow = 1 AND favorited = 1")
    fun getTvShowFav(): LiveData<List<MoviesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MoviesEntity>)

    @Update
    fun updateMovies(movies: MoviesEntity)

}