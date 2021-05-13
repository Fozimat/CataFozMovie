package com.fozimat.catafozmovie.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fozimat.catafozmovie.data.source.remote.response.MovieResponse
import com.fozimat.catafozmovie.utils.EspressoIdlingResource
import com.fozimat.catafozmovie.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed(
            {
                resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
                EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
        return resultMovie
    }

    fun getAllTvShow(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed(
            {
                resultMovie.value = ApiResponse.success(jsonHelper.loadTvShow())
                EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
        return resultMovie
    }

    interface LoadMovieCallBack {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadShowCallBack {
        fun onAllShowReceived(MovieResponse: List<MovieResponse>)
    }
}