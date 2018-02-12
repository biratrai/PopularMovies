package com.gooner10.popularmoviesapp.Activity.moviedetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gooner10.popularmoviesapp.Activity.movieBus.OnItemClickEvent;
import com.gooner10.popularmoviesapp.Activity.data.Constants;
import com.gooner10.popularmoviesapp.Activity.data.MovieData;
import com.gooner10.popularmoviesapp.Activity.movielist.MovieActivity;
import com.gooner10.popularmoviesapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class MovieDetail extends AppCompatActivity {

    private MovieData movie;

    @BindView(R.id.movie_description)
    TextView movieDescription;

    @BindView(R.id.vote_average)
    TextView voteAverage;

    @BindView(R.id.release_date)
    TextView releaseDate;

    @BindView(R.id.detailRatingBar)
    RatingBar mDetailRatingBar;

//    @Bind(R.id.releaseDateTextView)
//    TextView mReleaseDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // assert the null pointer exception error
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Register to the bus
        EventBus.getDefault().registerSticky(this);

        // Set the image view to the Detail Activity
        loadBackdrop();

        // Set the relevant text to the field
        movieDescription.setText(movie.mOverview);
        releaseDate.setText(movie.getmReleaseDate());
        voteAverage.setText(movie.getmVoteAverage());

//        mReleaseDateText.setText("Release Date: " + movie.getmReleaseDate());

        float movie_rating = Float.parseFloat(movie.getmVoteAverage()) / 2;

        mDetailRatingBar.setRating((movie_rating));

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(movie.getmTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.detail_fab_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // onEvent Receive the Event
    public void onEventMainThread(OnItemClickEvent event) {
        movie = (MovieData) event.bundle.get("movie_data");
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(Constants.BACKDROP_PATH + movie.mBackdropPath).centerCrop().into(imageView);
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