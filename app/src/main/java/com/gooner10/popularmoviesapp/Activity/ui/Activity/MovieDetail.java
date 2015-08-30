package com.gooner10.popularmoviesapp.Activity.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gooner10.popularmoviesapp.Activity.MovieBus.MovieBus;
import com.gooner10.popularmoviesapp.Activity.MovieBus.MovieDetailBusEvent;
import com.gooner10.popularmoviesapp.Activity.domain.Model.Constants;
import com.gooner10.popularmoviesapp.Activity.domain.Model.MovieData;
import com.gooner10.popularmoviesapp.R;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetail extends AppCompatActivity {

    private Toolbar toolbar;
    MovieData movie;

    @Bind(R.id.movie_description)
    TextView movieDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        movie = (MovieData) this.getIntent().getExtras().get("movie_data");
        movieDescription.setText(movie.mOverview);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(movie.getmTitle());
        loadBackdrop();

        // Register to the bus
        MovieBus.getInstance().register(this);

    }

    @Subscribe
    public void onReceiveData(MovieDetailBusEvent movieDetailBusEvent) {
        Log.d("TAG", "onReceiveData: " + movieDetailBusEvent);
        MovieData movieData = (MovieData) movieDetailBusEvent.bundle.get("movie_data");
        Toast.makeText(this,"onReceiveData: "+movieData.getmTitle(),Toast.LENGTH_SHORT).show();
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(Constants.BACKDROP_PATH + movie.mBackdropPath).centerCrop().into(imageView);
//        Log.d("moviedetail","detail "+movie.mBackdropPath);
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
