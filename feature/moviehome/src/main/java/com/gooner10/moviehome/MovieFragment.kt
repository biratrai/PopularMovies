package com.gooner10.moviehome

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
import com.gooner10.data.model.MovieItem
import com.gooner10.moviehome.databinding.FragmentMovieBinding
//import hugo.weaving.DebugLog
//import kotlinx.android.synthetic.main.fragment_movie.view.*
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
        val binding = FragmentMovieBinding.inflate(inflater, container, false)
//        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        binding.recyclerViewMovie.layoutManager = GridLayoutManager(requireActivity(), 2)
        movieFragmentAdapter = MovieFragmentAdapter(requireActivity() as Context, ArrayList())
        binding.recyclerViewMovie.adapter = movieFragmentAdapter
        Log.i(TAG, "onCreateView movieFragmentAdapter: " + movieFragmentAdapter!!)
        val movieViewModel = ViewModelProviders.of(requireActivity()).get(MovieViewModel::class.java)
        movieViewModel.getMovieDataList().observe(requireActivity(), Observer { movieDataList -> displayMovieList(movieDataList) })
        return binding.root
    }

    //@DebugLog
    override fun displayMovieList(movieDataList: List<MovieItem>) {
        Log.i(TAG, "displayMovieList movieFragmentAdapter: " + movieFragmentAdapter!!)
        movieFragmentAdapter!!.setData(movieDataList)
    }

}
