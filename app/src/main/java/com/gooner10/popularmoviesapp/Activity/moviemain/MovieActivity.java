package com.gooner10.popularmoviesapp.Activity.moviemain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

import com.gooner10.popularmoviesapp.Activity.moviefavourite.FavouriteFragment;
import com.gooner10.popularmoviesapp.Activity.moviesettings.SettingsActivity;
import com.gooner10.popularmoviesapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity {

    private final String LOG_TAG = MovieActivity.class.getSimpleName();
    private final Fragment movieFragment = new MovieFragment();
    private final FavouriteFragment favouriteFragment = new FavouriteFragment();
    public static final String TAG = MovieActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tablayout;


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
        tablayout = findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewPager);

        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPref.getString(getString(R.string.pref_sort_choice), "default value");
        Log.d("TAG", username);
    }

    private void setupViewPager() {
        if (viewPager != null) {
            MovieAdapter mMovieAdapter = new MovieAdapter(getSupportFragmentManager());
            mMovieAdapter.addFragment(movieFragment, "Popular Movies");
            mMovieAdapter.addFragment(favouriteFragment, "Favourites");
            viewPager.setAdapter(mMovieAdapter);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    Log.i(TAG, "onPageScrolled: " + position);
                }

                @Override
                public void onPageSelected(int position) {
                    Log.i(TAG, "onPageSelected: " + position);
                    if (position == 0) {

                    } else if (position == 1) {
                        favouriteFragment.setData();
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    Log.i(TAG, "onPageScrollStateChanged: " + state);
                }
            });
        }
    }

    private void setUpHamburger() {
        // Set up the hamburger icon to open and close the drawer
        ActionBarDrawerToggle mActionDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        drawerLayout.setDrawerListener(mActionDrawerToggle);
        mActionDrawerToggle.syncState();
    }

    private void setUpToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private void setupNavigationView() {
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_launcher);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(GravityCompat.START);
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
