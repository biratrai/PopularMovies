package com.gooner10.popularmoviesapp.moviedetail;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gooner10.popularmoviesapp.R;
import com.gooner10.popularmoviesapp.data.Constants;
import com.gooner10.popularmoviesapp.data.IMovieRepository;
import com.gooner10.popularmoviesapp.data.MovieItem;
import com.gooner10.popularmoviesapp.data.MovieRepositoryImpl;
import com.gooner10.popularmoviesapp.moviemain.MovieActivity;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

import static com.gooner10.popularmoviesapp.moviemain.MovieFragmentAdapter.MOVIE_DATA;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String TAG = MovieDetailActivity.class.getSimpleName();
    private MovieItem movie;
    private IMovieRepository movieRepository;

    @BindView(R.id.movie_description)
    TextView movieDescription;

    @BindView(R.id.vote_average)
    TextView voteAverage;

    @BindView(R.id.release_date)
    TextView releaseDate;

    @BindView(R.id.detailRatingBar)
    RatingBar mDetailRatingBar;

    @BindView(R.id.detail_fab_button)
    FloatingActionButton favoriteButton;

    @BindView(R.id.backdrop)
    ImageView imageView;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // assert the null pointer exception error
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movie = getIntent().getParcelableExtra(MOVIE_DATA);
        // Set the image view to the Detail Activity
        loadBackdrop();

        movieRepository = MovieRepositoryImpl.getMovieDatabaseInstance(this);

        // Set the relevant text to the field
        movieDescription.setText(movie.getOverview());
        releaseDate.setText(movie.getReleaseDate());
        voteAverage.setText(String.format(Locale.getDefault(), "%1$,.1f", movie.getVoteAverage()));

        float movieRating = Float.parseFloat(String.valueOf(movie.getVoteAverage())) / 2;

        mDetailRatingBar.setRating(movieRating);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(movie.getTitle());

        setFavorite(movieRepository.findMovieAlreadyIsFavorite(movie));
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDatabase();
            }
        });
    }

    @DebugLog
    private void setFavorite(boolean isFavorite) {
        Drawable drawable;
        if (isFavorite) {
            drawable = ContextCompat.getDrawable(this, R.drawable.ic_favorite_24dp);
        } else {
            drawable = ContextCompat.getDrawable(this, R.drawable.ic_favorite_white_24dp);
        }
        favoriteButton.setImageDrawable(drawable);
    }

    @DebugLog
    private void addToDatabase() {
        Log.i(TAG, "addToDatabase: " + movieRepository.getMovie());
        if (!movieRepository.findMovieAlreadyIsFavorite(movie)) {
            movieRepository.insertOrUpdateMovieData(movie);
            setFavorite(true);
        } else {
            setFavorite(false);
            movieRepository.deleteAllMovieData(movie);
        }
    }

    private void loadBackdrop() {
        Glide.with(this).load(Constants.BACKDROP_PATH + movie.getBackdropPath()).centerCrop().into(imageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MovieActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
