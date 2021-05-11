package com.fozimat.catafozmovie.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fozimat.catafozmovie.R
import com.fozimat.catafozmovie.data.MoviesEntity
import com.fozimat.catafozmovie.databinding.ActivityDetailBinding
import com.fozimat.catafozmovie.databinding.ContentDetailMovieBinding
import com.fozimat.catafozmovie.utils.MovieType
import com.fozimat.catafozmovie.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        val type = extras?.getString(EXTRA_TYPE)
        if (extras != null) {
            when (type) {
                MovieType.MOVIE.type -> {
                    val title = extras.getString(EXTRA_MOVIE)
                    if (title != null) {
                        activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                        activityDetailMovieBinding.content.visibility = View.VISIBLE

                        viewModel.setSelectedMovie(title)
                        viewModel.getDetailMovie().observe(this, {
                            activityDetailMovieBinding.progressBar.visibility = View.GONE
                            activityDetailMovieBinding.content.visibility = View.VISIBLE
                        })

                        viewModel.getDetailMovie().observe(this, { movie ->
                            populateMovie(movie)
                        })
                    }
                }
                MovieType.SHOW.type -> {
                    val title = extras.getString(EXTRA_TV)
                    if (title != null) {
                        activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                        activityDetailMovieBinding.content.visibility = View.VISIBLE

                        viewModel.setSelectedMovie(title)
                        viewModel.getDetailShow().observe(this, {
                            activityDetailMovieBinding.progressBar.visibility = View.GONE
                            activityDetailMovieBinding.content.visibility = View.VISIBLE
                        })

                        viewModel.getDetailShow().observe(this, { movie ->
                            populateMovie(movie)
                        })
                    }
                }
            }
        }
    }

    private fun populateMovie(movieEntity: MoviesEntity) {
        detailContentBinding.apply {
            tvItemTitle.text = movieEntity.title
            tvItemYear.text = movieEntity.year.toString()
            tvItemGenre.text = movieEntity.genre
            tvItemDetail.text = movieEntity.description
            tvItemDuration.text = movieEntity.duration
        }
        Glide.with(this)
            .load(movieEntity.image)
            .apply(RequestOptions())
            .into(detailContentBinding.imgMovies)
    }
}