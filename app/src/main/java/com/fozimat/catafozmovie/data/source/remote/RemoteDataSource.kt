package com.fozimat.catafozmovie.data.source.remote

import android.os.Handler
import android.os.Looper
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

    fun getAllMovies(callback: LoadMovieCallBack) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onAllMoviesReceived(jsonHelper.loadMovies())
                EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getAllTvShow(callback: LoadShowCallBack) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onAllShowReceived(jsonHelper.loadTvShow())
                EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadMovieCallBack {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadShowCallBack {
        fun onAllShowReceived(MovieResponse: List<MovieResponse>)
    }
}