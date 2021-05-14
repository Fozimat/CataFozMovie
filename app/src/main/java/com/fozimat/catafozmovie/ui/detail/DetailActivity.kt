package com.fozimat.catafozmovie.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fozimat.catafozmovie.R
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.databinding.ActivityDetailBinding
import com.fozimat.catafozmovie.databinding.ContentDetailMovieBinding
import com.fozimat.catafozmovie.utils.MovieType
import com.fozimat.catafozmovie.viewmodel.ViewModelFactory
import com.fozimat.catafozmovie.vo.Status

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var detailContentBinding: ContentDetailMovieBinding
    private var menu: Menu? = null
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
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
                        viewModel.setSelectedMovie(title)
                        viewModel.movie.observe(this, {
                            if (it != null) {
                                when (it.status) {
                                    Status.LOADING -> {
                                        activityDetailMovieBinding.progressBar.visibility =
                                            View.VISIBLE
                                    }
                                    Status.SUCCESS -> {
                                        activityDetailMovieBinding.progressBar.visibility =
                                            View.GONE
                                        activityDetailMovieBinding.content.visibility = View.VISIBLE
                                        it.data?.let { it1 -> populateMovie(it1) }
                                    }
                                    Status.ERROR -> {
                                        activityDetailMovieBinding.progressBar.visibility =
                                            View.GONE
                                        Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT)
                                            .show()
                                    }

                                }
                            }
                        })
                    }
                }
                MovieType.SHOW.type -> {
                    val title = extras.getString(EXTRA_TV)
                    if (title != null) {
                        viewModel.setSelectedMovie(title)
                        viewModel.tvShow.observe(this, {
                            if (it != null) {
                                when (it.status) {
                                    Status.LOADING -> {
                                        activityDetailMovieBinding.progressBar.visibility =
                                            View.VISIBLE
                                    }
                                    Status.SUCCESS -> {
                                        activityDetailMovieBinding.progressBar.visibility =
                                            View.GONE
                                        activityDetailMovieBinding.content.visibility = View.VISIBLE
                                        it.data?.let { it1 -> populateTvShowMovie(it1) }
                                    }
                                    Status.ERROR -> {
                                        activityDetailMovieBinding.progressBar.visibility =
                                            View.GONE
                                        Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                            }
                        })
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fav, menu)
        this.menu = menu

        val extras = intent.extras
        val type = extras?.getString(EXTRA_TYPE)
        if (extras != null) {
            when (type) {
                MovieType.MOVIE.type -> {
                    viewModel.movie.observe(this, {
                        if (it != null) {
                            val state = it.data?.favorited
                            if (state != null) {
                                setFavState(state)
                            }
                        }
                    })
                }
                MovieType.SHOW.type -> {
                    viewModel.tvShow.observe(this, {
                        if (it != null) {
                            val state = it.data?.favorited
                            if (state != null) {
                                setFavState(state)
                            }
                        }
                    })
                }
            }
        }
        return super.onCreateOptionsMenu(menu)
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

    private fun populateTvShowMovie(tvShowEntity: TvShowEntity) {
        detailContentBinding.apply {
            tvItemTitle.text = tvShowEntity.title
            tvItemYear.text = tvShowEntity.year.toString()
            tvItemGenre.text = tvShowEntity.genre
            tvItemDetail.text = tvShowEntity.description
            tvItemDuration.text = tvShowEntity.duration
        }
        Glide.with(this)
            .load(tvShowEntity.image)
            .apply(RequestOptions())
            .into(detailContentBinding.imgMovies)
    }

    private fun setFavState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.button_fav)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this@DetailActivity, R.drawable.ic_favorite)
        } else {
            menuItem?.icon =
                ContextCompat.getDrawable(this@DetailActivity, R.drawable.ic_not_favorite)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.button_fav) {
            viewModel.setFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}