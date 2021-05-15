package com.fozimat.catafozmovie.ui.favorite

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fozimat.catafozmovie.ui.favorite.movies.FavMoviesFragment
import com.fozimat.catafozmovie.ui.favorite.show.FavShowFragment

class SectionsPagerAdapter(fm: Fragment): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        when(position) {
            0 -> FavMoviesFragment()
            1 -> FavShowFragment()
            else -> Fragment()
        }
}