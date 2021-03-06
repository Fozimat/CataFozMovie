package com.fozimat.catafozmovie.ui.show

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fozimat.catafozmovie.R
import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.local.entity.TvShowEntity
import com.fozimat.catafozmovie.databinding.ItemsTvBinding
import com.fozimat.catafozmovie.ui.detail.DetailActivity
import com.fozimat.catafozmovie.utils.MovieType

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.title == newItem.title
            }
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val itemsBinding =
            ItemsTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if( movie != null) {
            holder.bind(movie)
        }
    }

    class MovieViewHolder(private val binding: ItemsTvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDetail.text = movie.description
                Glide.with(itemView.context)
                    .load(movie.image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgMovies)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, movie.title)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, MovieType.SHOW.type)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}