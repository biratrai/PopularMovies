package com.gooner10.popularmoviesapp.moviemain

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.gooner10.popularmoviesapp.R
import com.gooner10.popularmoviesapp.data.MovieItem
import hugo.weaving.DebugLog
import kotlinx.android.synthetic.main.fragment_movie.view.*
import java.util.*

/**
 * Movie Fragment to display the Movie List in GridLayout
 */

class MovieFragment : Fragment(), MovieContract.View {
    companion object {
        private val TAG = "MovieFragment"
    }

    private var movieFragmentAdapter: MovieFragmentAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        view.recyclerViewMovie.layoutManager = GridLayoutManager(activity, 2)
        movieFragmentAdapter = MovieFragmentAdapter(activity as Context, ArrayList())
        view.recyclerViewMovie.adapter = movieFragmentAdapter
        Log.i(TAG, "onCreateView movieFragmentAdapter: " + movieFragmentAdapter!!)
        val movieViewModel = ViewModelProviders.of(activity!!).get(MovieViewModel::class.java)
        Log.i(TAG, "loadData getMovieDataList: " + movieViewModel.movieDataList)
        movieViewModel.movieDataList.observe(activity!!, Observer { movieDataList -> displayMovieList(movieDataList) })
        return view
    }

    @DebugLog
    override fun displayMovieList(movieDataList: List<MovieItem>?) {
        Log.i(TAG, "displayMovieList movieFragmentAdapter: " + movieFragmentAdapter!!)
        movieFragmentAdapter!!.setData(movieDataList)
    }

}
