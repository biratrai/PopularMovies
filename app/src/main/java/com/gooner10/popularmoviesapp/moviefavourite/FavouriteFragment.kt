package com.gooner10.popularmoviesapp.moviefavourite


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gooner10.popularmoviesapp.R
import com.gooner10.popularmoviesapp.data.MovieItem
import hugo.weaving.DebugLog
import kotlinx.android.synthetic.main.fragment_favourite.view.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class FavouriteFragment : Fragment(), MovieFavouriteContract.View {
    private var favoriteMovieFragmentAdapter: FavoriteMovieFragmentAdapter? = null
    private var presenter: MovieFavouriteContract.Presenter? = null

    @DebugLog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    @DebugLog
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.favourite_recyclerview.layoutManager = GridLayoutManager(activity, 2)
        favoriteMovieFragmentAdapter = FavoriteMovieFragmentAdapter(activity as Context, ArrayList())
        view.favourite_recyclerview.adapter = favoriteMovieFragmentAdapter
    }

    @DebugLog
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = MovieFavoritePresenter(activity as Context, this)
        setData()
    }

    @DebugLog
    override fun displayFavoriteMovie(movieDataList: List<MovieItem>) {
        favoriteMovieFragmentAdapter!!.setData(movieDataList)
    }

    fun setData() {
        Log.d(TAG, "setData: " + presenter!!)
        if (presenter != null) {
            presenter!!.loadFavoriteMovieFromRepository()
        }
    }

    companion object {
        val TAG = FavouriteFragment::class.java.simpleName
    }

}
