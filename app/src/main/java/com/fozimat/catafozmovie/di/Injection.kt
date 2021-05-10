package com.fozimat.catafozmovie.di

import android.content.Context
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.remote.RemoteDataSource
import com.fozimat.catafozmovie.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MovieRepository.getInstance(remoteDataSource)
    }
}