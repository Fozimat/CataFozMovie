package com.fozimat.catafozmovie.ui.favorite.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fozimat.catafozmovie.databinding.FragmentShowBinding
import com.fozimat.catafozmovie.ui.show.TvShowAdapter
import com.fozimat.catafozmovie.viewmodel.ViewModelFactory

class FavShowFragment : Fragment() {

    private lateinit var fragmentShowBinding: FragmentShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentShowBinding = FragmentShowBinding.inflate(layoutInflater, container, false)
        return fragmentShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[FavShowViewModel::class.java]

            val movieAdapter = TvShowAdapter()

            fragmentShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getShowMovies().observe(viewLifecycleOwner, { movies ->
                fragmentShowBinding.progressBar.visibility = View.GONE
                movieAdapter.setMovies(movies)
                movieAdapter.notifyDataSetChanged()
            })

            with(fragmentShowBinding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}