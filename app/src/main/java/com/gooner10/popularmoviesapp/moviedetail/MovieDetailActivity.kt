package com.gooner10.popularmoviesapp.moviedetail

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.gooner10.popularmoviesapp.R
import com.gooner10.popularmoviesapp.data.Constants
import com.gooner10.popularmoviesapp.data.IMovieRepository
import com.gooner10.popularmoviesapp.data.MovieItem
import com.gooner10.popularmoviesapp.data.MovieRepositoryImpl
import com.gooner10.popularmoviesapp.moviemain.MovieActivity
import com.gooner10.popularmoviesapp.moviemain.MovieFragmentAdapter.Companion.MOVIE_DATA
import hugo.weaving.DebugLog
import kotlinx.android.synthetic.main.activity_movie_detail.*
import java.util.*

class MovieDetailActivity : AppCompatActivity() {
    private var movie: MovieItem? = null
    private var movieRepository: IMovieRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setSupportActionBar(toolbar)

        // assert the null pointer exception error
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        movie = intent.getParcelableExtra(MOVIE_DATA)
        // Set the image view to the Detail Activity
        loadBackdrop()

        movieRepository = MovieRepositoryImpl.getMovieDatabaseInstance(this)

        // Set the relevant text to the field
        movie_description.text = movie!!.overview
        release_date.text = movie!!.releaseDate
        vote_average.text = String.format(Locale.getDefault(), "%1$,.1f", movie!!.voteAverage)

        val movieRating = java.lang.Float.parseFloat(movie!!.voteAverage.toString()) / 2

        detailRatingBar.rating = movieRating

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        collapsingToolbar.title = movie!!.title

        setFavorite(movieRepository!!.findMovieAlreadyIsFavorite(movie!!))
        detail_fab_button!!.setOnClickListener { addToDatabase() }
    }

    @DebugLog
    private fun setFavorite(isFavorite: Boolean) {
        val drawable: Drawable? = if (isFavorite) {
            ContextCompat.getDrawable(this, R.drawable.ic_favorite_24dp)
        } else {
            ContextCompat.getDrawable(this, R.drawable.ic_favorite_white_24dp)
        }
        detail_fab_button.setImageDrawable(drawable)
    }

    @DebugLog
    private fun addToDatabase() {
        Log.i(TAG, "addToDatabase: " + movieRepository!!.movie)
        if (!movieRepository!!.findMovieAlreadyIsFavorite(movie)) {
            movieRepository!!.insertOrUpdateMovieData(movie)
            setFavorite(true)
        } else {
            setFavorite(false)
            movieRepository!!.deleteAllMovieData(movie)
        }
    }

    private fun loadBackdrop() {
        Glide.with(this).load(Constants.BACKDROP_PATH + movie!!.backdropPath).centerCrop().into(backdrop!!)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> {
                val homeIntent = Intent(this, MovieActivity::class.java)
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(homeIntent)
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

    companion object {

        private val TAG = MovieDetailActivity::class.java.simpleName

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }
}
