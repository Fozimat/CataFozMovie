package com.fozimat.catafozmovie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fozimat.catafozmovie.data.source.MovieDataSource
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.remote.RemoteDataSource
import com.fozimat.catafozmovie.data.source.remote.response.MovieResponse

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    override fun getAllMovies(): LiveData<List<MoviesEntity>> {
        val movieResults = MutableLiveData<List<MoviesEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallBack {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in movieResponse) {
                    val movie = MoviesEntity(
                        response.title,
                        response.year,
                        response.genre,
                        response.description,
                        response.duration,
                        response.image
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvShow(): LiveData<List<MoviesEntity>> {
        val movieResults = MutableLiveData<List<MoviesEntity>>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadShowCallBack {
            override fun onAllShowReceived(MovieResponse: List<MovieResponse>) {
                val tvList = ArrayList<MoviesEntity>()
                for (response in MovieResponse) {
                    val tv = MoviesEntity(
                        response.title,
                        response.year,
                        response.genre,
                        response.description,
                        response.duration,
                        response.image
                    )
                    tvList.add(tv)
                }
                movieResults.postValue(tvList)
            }
        })
        return movieResults
    }

    override fun getDetailMovie(title: String): LiveData<MoviesEntity> {
        val movieResults = MutableLiveData<MoviesEntity>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallBack {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: MoviesEntity
                for (response in movieResponse) {
                    if (response.title == title) {
                        movie = MoviesEntity(
                            response.title,
                            response.year,
                            response.genre,
                            response.description,
                            response.duration,
                            response.image
                        )
                    }
                }
                movieResults.postValue(movie)
            }
        })
        return movieResults
    }

    override fun getDetailShow(title: String): LiveData<MoviesEntity> {
        val movieResults = MutableLiveData<MoviesEntity>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadShowCallBack {
            override fun onAllShowReceived(MovieResponse: List<MovieResponse>) {
                lateinit var movie: MoviesEntity
                for (response in MovieResponse) {
                    if (response.title == title) {
                        movie = MoviesEntity(
                            response.title,
                            response.year,
                            response.genre,
                            response.description,
                            response.duration,
                            response.image
                        )
                    }
                }
                movieResults.postValue(movie)
            }
        })
        return movieResults
    }

}