package com.gooner10.popularmoviesapp.Activity.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gooner10.popularmoviesapp.Activity.domain.Model.MovieData;
import com.gooner10.popularmoviesapp.Activity.ui.adapter.MovieAdapter;
import com.gooner10.popularmoviesapp.Activity.ui.fragments.FavouriteFragment;
import com.gooner10.popularmoviesapp.Activity.ui.fragments.MovieFragment;
import com.gooner10.popularmoviesapp.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity {

    private final String LOG_TAG = "MovieActivity";

    private final Fragment mMovieFragment = new MovieFragment();
    private final Fragment mFavouriteFragment = new FavouriteFragment();
    private final ArrayList<MovieData> mMovieDataArrayList = new ArrayList<>();

    private String title;
    private String overview;
    private String poster_path;
    private String vote_average;
    private String release_date;
    private String backdrop_path;
    private String vote_count;
    private String popularity;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    @Bind(R.id.tabs)
    TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        // Bind all of the view
        ButterKnife.bind(this);

        // Setup Toolbar
        setUpToolbar();

        // Setup NavigationDrawer
        setupNavigationView();

        // Setup ViewPager
        setupViewPager();

        setUpHamburger();
        // Initialize Tabs
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager() {
        if (mViewPager != null) {
            MovieAdapter mMovieAdapter = new MovieAdapter(getSupportFragmentManager());
            mMovieAdapter.addFragment(mMovieFragment, "Popular Movies");
            mMovieAdapter.addFragment(mFavouriteFragment, "Favourites");
            mViewPager.setAdapter(mMovieAdapter);
        }
    }

    private void setUpHamburger() {
        // Set up the hamburger icon to open and close the drawer
        ActionBarDrawerToggle mActionDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mActionDrawerToggle);
        mActionDrawerToggle.syncState();
    }

    private void setUpToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }

    private void setupNavigationView() {
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(R.drawable.ic_launcher);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                    Log.d(LOG_TAG, "onClick");
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MovieActivity.this, SettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
