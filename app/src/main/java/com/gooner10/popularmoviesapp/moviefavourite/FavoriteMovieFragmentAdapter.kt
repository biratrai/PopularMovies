package com.gooner10.popularmoviesapp.moviefavourite

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.gooner10.popularmoviesapp.R
import com.gooner10.popularmoviesapp.data.Constants
import com.gooner10.popularmoviesapp.data.MovieItem
import com.squareup.picasso.Picasso

/**
 * Adapter for Favorite Movie Fragment
 */

class FavoriteMovieFragmentAdapter(private val context: Context, private var movieData: List<MovieItem>?) : RecyclerView.Adapter<FavoriteMovieFragmentAdapter.MovieFavoriteViewHolder>() {
    private val layoutInflater: LayoutInflater

    init {
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieFavoriteViewHolder {
        val view = layoutInflater.inflate(R.layout.favorite_movie_row, parent, false)
        return MovieFavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieFavoriteViewHolder, position: Int) {
        holder.favoriteMovieText.text = movieData!![position].title
        Picasso.with(context)
                .load(Constants.POSTER_PATH + movieData!![position].posterPath)
                .placeholder(R.drawable.ic_headset)
                .error(R.drawable.ic_done)
                .into(holder.favoriteMovieImage)
    }

    override fun getItemCount(): Int {
        return movieData!!.size
    }

    fun setData(movieDataList: List<MovieItem>) {
        this.movieData = movieDataList
        notifyDataSetChanged()
    }

    inner class MovieFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var favoriteMovieText: TextView
        internal var favoriteMovieImage: ImageView

        init {
            favoriteMovieText = itemView.findViewById(R.id.favorite_movie_text)
            favoriteMovieImage = itemView.findViewById(R.id.favorite_movie_imageView)
        }
    }
}
