package com.fozimat.catafozmovie.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.fozimat.catafozmovie.R
import com.fozimat.catafozmovie.databinding.FragmentFavoriteBinding
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteFragment : Fragment() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tvShow)
    }

    private lateinit var fragmentFavoriteBinding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        fragmentFavoriteBinding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(
            fragmentFavoriteBinding.tabs,
            fragmentFavoriteBinding.viewPager
        ) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }
}