package com.gooner10.popularmoviesapp.Activity.ui.Activity;

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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gooner10.popularmoviesapp.Activity.Network.JsonParser;
import com.gooner10.popularmoviesapp.Activity.Network.VolleySingleton;
import com.gooner10.popularmoviesapp.Activity.domain.Model.MovieData;
import com.gooner10.popularmoviesapp.Activity.ui.Adapter.MovieAdapter;
import com.gooner10.popularmoviesapp.Activity.ui.Fragments.FavouriteFragment;
import com.gooner10.popularmoviesapp.Activity.ui.Fragments.MovieFragment;
import com.gooner10.popularmoviesapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class MovieActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    private ActionBarDrawerToggle mActionDrawerToggle;
    public String LOG_TAG = "MovieActivity";

    Fragment mMovieFragment = new MovieFragment();
    Fragment mFavouriteFragment = new FavouriteFragment();
    private static MovieData mMovideData;
    ArrayList<MovieData> mMovieDataArrayList = new ArrayList<>();

    String id, title, overview, poster_path, vote_average, release_date, backdrop_path, vote_count, popularity;
    JsonParser jsonParser = new JsonParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        // Setup Toolbar
        setUpToolbar();

        // Setup NavigationDrawer
        setupNavigationView();

        // Setup ViewPager
        setupViewPager();

        // Initialize Tabs
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        ParseJSON();
//        MovieBus.getInstance().register(this);
    }

    private void ParseJSON() {
//        mMovieDataArrayList = jsonParser.ParseJson();
        JsonParser();
//        Log.d(LOG_TAG, "ParseJSON" + mMovieDataArrayList);
    }

    public class parseCompleteEvent {
        private ArrayList<MovieData> arrayList;

        public parseCompleteEvent(ArrayList<MovieData> dataArrayList) {
            this.arrayList = dataArrayList;
        }

        public ArrayList<MovieData> getData() {
            return arrayList;
        }

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
        mActionDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mActionDrawerToggle);
        mActionDrawerToggle.syncState();
    }

    private void setUpToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }


    public void JsonParser() {
        final String url = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=530c5cfd24953abae83df3e614c6d774";
        Log.d("MovieActivity", "JsonParser");
        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("MovieActivity", "" + response);
                parseJSONresponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsObjRequest);

    }

    private void parseJSONresponse(JSONObject response) {
        try {
            String jsonString = response.getString("results");

            JSONArray jsonArray = new JSONArray(jsonString);
            Log.i(LOG_TAG, "Array" + jsonArray.getClass());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                id = jsonObject.getString("id");
                title = jsonObject.getString("original_title");
                overview = jsonObject.getString("overview");
                release_date = jsonObject.getString("release_date");
                poster_path = jsonObject.getString("poster_path");
                backdrop_path = jsonObject.getString("backdrop_path");
                vote_average = jsonObject.getString("vote_average");
                vote_count = jsonObject.getString("vote_count");
                vote_average = jsonObject.getString("vote_average");
                popularity = jsonObject.getString("popularity");
                mMovideData = new MovieData(id, title, overview, poster_path, vote_average, vote_count,
                        release_date, popularity, backdrop_path);
                mMovieDataArrayList.add(mMovideData);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(LOG_TAG, "" + mMovieDataArrayList);
//        EventBus.getDefault().postSticky(mMovieDataArrayList);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
