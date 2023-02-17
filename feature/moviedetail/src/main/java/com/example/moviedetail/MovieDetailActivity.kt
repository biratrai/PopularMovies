package com.example.moviedetail

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
import com.gooner10.data.IMovieRepository
import com.gooner10.data.MovieItem
import com.gooner10.data.MovieRepositoryImpl
import com.gooner10.moviedetail.R
import com.gooner10.moviedetail.databinding.ActivityMovieDetailBinding
//import hugo.weaving.DebugLog
//import kotlinx.android.synthetic.main.activity_movie_detail.*
import java.util.*

class MovieDetailActivity : AppCompatActivity() {
    private var movie: MovieItem? = null
    private var movieRepository: IMovieRepository? = null
    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // assert the null pointer exception error
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        movie = intent.getParcelableExtra(MOVIE_DATA)
        // Set the image view to the Detail Activity
        loadBackdrop()

        movieRepository = MovieRepositoryImpl.getMovieDatabaseInstance(this)

        // Set the relevant text to the field
        binding.movieDescription.text = movie!!.overview
        binding.releaseDate.text = movie!!.releaseDate
        binding.voteAverage.text = String.format(Locale.getDefault(), "%1$,.1f", movie!!.voteAverage)

        val movieRating = java.lang.Float.parseFloat(movie!!.voteAverage.toString()) / 2

        binding.detailRatingBar.rating = movieRating

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        collapsingToolbar.title = movie!!.title

        setFavorite(movieRepository!!.findMovieAlreadyIsFavorite(movie!!))
        binding.detailFabButton.setOnClickListener { addToDatabase() }
    }

    //@DebugLog
    private fun setFavorite(isFavorite: Boolean) {
        val drawable: Drawable? = if (isFavorite) {
            ContextCompat.getDrawable(this, R.drawable.ic_favorite_24dp)
        } else {
            ContextCompat.getDrawable(this, R.drawable.ic_favorite_white_24dp)
        }
        binding.detailFabButton.setImageDrawable(drawable)
    }

    //@DebugLog
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
        Glide.with(this).load("https://static-media.fox.com/ms/stg1/sports/play-5c0cbe38d0000db--gimenez.png").centerCrop().into(binding.backdrop!!)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> {
//                val homeIntent = Intent(this, MovieActivity::class.java)
//                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                startActivity(homeIntent)
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

    companion object {

        private val TAG = MovieDetailActivity::class.java.simpleName
        const val MOVIE_DATA = "movie_data"

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }
}
