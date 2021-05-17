package com.fozimat.catafozmovie.data

import androidx.lifecycle.LiveData
import com.fozimat.catafozmovie.data.source.MovieDataSource
import com.fozimat.catafozmovie.data.source.local.LocalDataSource
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.data.source.remote.ApiResponse
import com.fozimat.catafozmovie.data.source.remote.RemoteDataSource
import com.fozimat.catafozmovie.data.source.remote.response.MovieResponse
import com.fozimat.catafozmovie.utils.AppExecutors
import com.fozimat.catafozmovie.vo.Resource

class FakeMovieRepository constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieDataSource {

    override fun getAllMovies(): LiveData<Resource<List<MoviesEntity>>> {
        return object :
            NetworkBoundResource<List<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MoviesEntity>> =
                localDataSource.getMovies()

            override fun shouldFetch(data: List<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in data) {
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
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<List<TvShowEntity>>> {
        return object :
            NetworkBoundResource<List<TvShowEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                localDataSource.getTvShow()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllTvShow()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val movie = TvShowEntity(
                        response.title,
                        response.year,
                        response.genre,
                        response.description,
                        response.duration,
                        response.image
                    )
                    movieList.add(movie)
                }
                localDataSource.insertTvShow(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(title: String): LiveData<Resource<MoviesEntity>> {
        return object : NetworkBoundResource<MoviesEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MoviesEntity> =
                localDataSource.getDetailMovie(title)

            override fun shouldFetch(data: MoviesEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in data) {
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
                localDataSource.insertMovies(movieList)
            }

        }.asLiveData()
    }

    override fun getDetailShow(title: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getDetailTvShow(title)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllTvShow()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val movie = TvShowEntity(
                        response.title,
                        response.year,
                        response.genre,
                        response.description,
                        response.duration,
                        response.image
                    )
                    movieList.add(movie)
                }
                localDataSource.insertTvShow(movieList)
            }

        }.asLiveData()
    }

    override fun getMoviesFav(): LiveData<List<MoviesEntity>> =
        localDataSource.getMoviesFav()

    override fun getTvShowFav(): LiveData<List<TvShowEntity>> =
        localDataSource.getTvShowFav()

    override fun setMoviesFav(movies: MoviesEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setMoviesFav(movies, state)
        }
    }

    override fun setTvShowFav(movies: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setTvShowFav(movies, state)
        }
    }

}