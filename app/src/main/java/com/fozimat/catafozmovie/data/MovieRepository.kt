package com.fozimat.catafozmovie.data

import androidx.lifecycle.LiveData
import com.fozimat.catafozmovie.data.source.MovieDataSource
import com.fozimat.catafozmovie.data.source.local.LocalDataSource
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.remote.ApiResponse
import com.fozimat.catafozmovie.data.source.remote.RemoteDataSource
import com.fozimat.catafozmovie.data.source.remote.response.MovieResponse
import com.fozimat.catafozmovie.utils.AppExecutors
import com.fozimat.catafozmovie.vo.Resource

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MoviesEntity>>> {
        return object :
            NetworkBoundResource<List<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MoviesEntity>> =
                localDataSource.getMovies()

            override fun shouldFetch(data: List<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(movieResponse: List<MovieResponse>) {
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
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<List<MoviesEntity>>> {
        return object :
            NetworkBoundResource<List<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MoviesEntity>> =
                localDataSource.getTvShow()

            override fun shouldFetch(data: List<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllTvShow()

            public override fun saveCallResult(movieResponse: List<MovieResponse>) {
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
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(title: String): LiveData<MoviesEntity> =
        localDataSource.getDetailMovie(title)

    override fun getDetailShow(title: String): LiveData<MoviesEntity> =
        localDataSource.getDetailTvShow(title)

    override fun getMoviesFav(): LiveData<List<MoviesEntity>> =
        localDataSource.getMoviesFav()

    override fun getTvShowFav(): LiveData<List<MoviesEntity>> =
        localDataSource.getTvShowFav()

    override fun setMoviesFav(movies: MoviesEntity, state: Boolean) {
        localDataSource.setMoviesFav(movies, state)
    }
}