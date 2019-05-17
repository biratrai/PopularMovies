package com.gooner10.popularmoviesapp.moviemain

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

/**
 * View pager for MovieActivity
 */
class MovieAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitlesList = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String) {

        fragmentList.add(fragment)
        fragmentTitlesList.add(title)

    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitlesList[position]
    }
}
