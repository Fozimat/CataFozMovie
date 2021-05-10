package com.fozimat.catafozmovie.ui.show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fozimat.catafozmovie.data.MoviesEntity
import com.fozimat.catafozmovie.databinding.ItemsTvBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MovieViewHolder>() {

    private var listMovies = ArrayList<MoviesEntity>()

    fun setMovies(movies: List<MoviesEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
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
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    class MovieViewHolder(private val binding: ItemsTvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MoviesEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDetail.text = movie.description
                Glide.with(itemView.context)
                    .load(movie.image)
                    .apply(RequestOptions())
                    .into(imgMovies)
//                itemView.setOnClickListener {
//                    val intent = Intent(itemView.context, DetailActivity::class.java)
//                    intent.putExtra(DetailActivity.EXTRA_TV, movie.title)
//                    intent.putExtra(DetailActivity.EXTRA_TYPE, MovieType.SHOW.type)
//                    itemView.context.startActivity(intent)
//                }
            }
        }
    }

}