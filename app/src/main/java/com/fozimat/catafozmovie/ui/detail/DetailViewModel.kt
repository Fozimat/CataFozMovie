package com.fozimat.catafozmovie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fozimat.catafozmovie.data.MovieRepository
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.vo.Resource

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private var title = MutableLiveData<String>()

    fun setSelectedMovie(title: String) {
        this.title.value = title
    }

    fun setSelectedTvShow(title: String) {
        this.title.value = title
    }

    var movie: LiveData<Resource<MoviesEntity>> = Transformations.switchMap(title) { title ->
        movieRepository.getDetailMovie(title)
    }

    var tvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(title) { title ->
        movieRepository.getDetailShow(title)
    }

    fun setFavorite() {
        val movieResource = movie.value
        val tvShowResource = tvShow.value

        if (movieResource != null) {
            val movieValue = movieResource.data
            if (movieValue != null) {
                val newState = !movieValue.favorited
                movieRepository.setMoviesFav(movieValue, newState)
            }
        }

        if (tvShowResource != null) {
            val movieValue = tvShowResource.data
            if (movieValue != null) {
                val newState = !movieValue.favorited
                movieRepository.setTvShowFav(movieValue, newState)
            }
        }
    }
}