package com.fozimat.catafozmovie.ui.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fozimat.catafozmovie.databinding.FragmentShowBinding
import com.fozimat.catafozmovie.viewmodel.ViewModelFactory
import com.fozimat.catafozmovie.vo.Status

class TvShowFragment : Fragment() {

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
            )[TvShowViewModel::class.java]

            val movieAdapter = TvShowAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> fragmentShowBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentShowBinding.progressBar.visibility = View.GONE
                            movieAdapter.setMovies(movies.data)
                            movieAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentShowBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentShowBinding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}