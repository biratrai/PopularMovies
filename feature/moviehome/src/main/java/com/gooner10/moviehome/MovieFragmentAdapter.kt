package com.gooner10.moviehome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
//import hugo.weaving.DebugLog

/**
 * Fragment adapter for the MovieFragment
 */

class MovieFragmentAdapter //@DebugLog
constructor(private val context: Context, private var movieData: List<com.gooner10.data.MovieItem>?) : RecyclerView.Adapter<MovieFragmentAdapter.ViewHolderData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.single_movie_row, parent, false)
        return ViewHolderData(view)
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        val movie = movieData!![position]
        Picasso.with(context)
                .load(Constants.POSTER_PATH + movie.posterPath)
                .placeholder(R.drawable.ic_headset)
                .error(R.drawable.ic_done)
                .into(holder.movieImageView)

        holder.view.setOnClickListener {
//            val intent = Intent(context, MovieDetailActivity::class.java)
//            val movieItem = movieData!![holder.adapterPosition]
//            val bundle = Bundle()
//            bundle.putParcelable(MOVIE_DATA, movieItem)
//            intent.putExtras(bundle)
//            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieData!!.size
    }

    fun setData(movieDataList: List<com.gooner10.data.MovieItem>?) {
        this.movieData = movieDataList
        notifyDataSetChanged()
    }

    inner class ViewHolderData(val view: View) : RecyclerView.ViewHolder(view) {
        val movieImageView: ImageView = view.findViewById(R.id.imageView)

    }

}
