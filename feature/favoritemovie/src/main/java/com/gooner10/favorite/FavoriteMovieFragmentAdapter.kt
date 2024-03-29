package com.gooner10.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gooner10.data.MovieItem

/**
 * Adapter for Favorite Movie Fragment
 */

class FavoriteMovieFragmentAdapter(private val context: Context, private var movieData: List<com.gooner10.data.MovieItem>?) : RecyclerView.Adapter<FavoriteMovieFragmentAdapter.MovieFavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieFavoriteViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.favorite_movie_row, parent, false)
        return MovieFavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieFavoriteViewHolder, position: Int) {
        holder.favoriteMovieText.text = movieData!![position].title
//        Picasso.with(context)
//                .load(Constants.POSTER_PATH + movieData!![position].posterPath)
//                .placeholder(R.drawable.ic_headset)
//                .error(R.drawable.ic_done)
//                .into(holder.favoriteMovieImage)
    }

    override fun getItemCount(): Int {
        return movieData!!.size
    }

    fun setData(movieDataList: List<MovieItem>) {
        this.movieData = movieDataList
        notifyDataSetChanged()
    }

    inner class MovieFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var favoriteMovieText: TextView = itemView.findViewById(R.id.favorite_movie_text)
        internal var favoriteMovieImage: ImageView = itemView.findViewById(R.id.favorite_movie_imageView)

    }
}
