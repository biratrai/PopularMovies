package com.gooner10.popularmoviesapp

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gooner10.moviehome.MovieFragment
import com.gooner10.popularmoviesapp.databinding.ActivityMovieBinding
import com.gooner10.popularmoviesapp.moviefavourite.FavouriteFragment
import com.gooner10.popularmoviesapp.trivia.MovieTriviaFragment
////import hugo.weaving.DebugLog
//import kotlinx.android.synthetic.main.activity_movie.*
//import kotlinx.android.synthetic.main.list_viewpager.*
//import kotlinx.android.synthetic.main.toolbar.*

class MovieActivity : AppCompatActivity() {
    private var movieFragment: Fragment? = null
    private var favouriteFragment: FavouriteFragment? = null
    private var triviaFragment: MovieTriviaFragment? = null
    private lateinit var binding: ActivityMovieBinding

//    //@DebugLog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Setup Toolbar
        setUpToolbar()

        // Setup NavigationDrawer
        setupNavigationView()

        // Setup ViewPager
        setupViewPager()

        setUpHamburger()
        // Initialize Tabs
        binding.viewpagerLayout.tabs.setupWithViewPager(binding.viewpagerLayout.viewpager)

//        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false)
//        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
//        val username = sharedPref.getString(getString(R.string.pref_sort_choice), "default value")
//        Log.d("TAG", username)
    }

    //@DebugLog
    private fun setupViewPager() {
//        Log.i(TAG, "setupViewPager: " + viewpager!!)
        val movieAdapter = MovieAdapter(supportFragmentManager)
        favouriteFragment = FavouriteFragment()
        movieFragment = MovieFragment()
        triviaFragment = MovieTriviaFragment()
        movieAdapter.addFragment(movieFragment as MovieFragment, "Popular")
        movieAdapter.addFragment(favouriteFragment!!, "Favourites")
        movieAdapter.addFragment(triviaFragment!!, "Trivia")
        Log.d(TAG, "setupViewPager favouriteFragment: " + favouriteFragment!!)
        binding.viewpagerLayout.viewpager.adapter = movieAdapter
        binding.viewpagerLayout.viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                Log.i(TAG, "onPageScrolled: $position")
            }

            override fun onPageSelected(position: Int) {
                Log.i(TAG, "onPageSelected: $position")
                if (position == 1) {
                    Log.d(TAG, "onPageSelected favouriteFragment: " + favouriteFragment!!)
                    favouriteFragment!!.setData()
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                Log.i(TAG, "onPageScrollStateChanged: $state")
            }
        })
    }

    private fun setUpHamburger() {
        // Set up the hamburger icon to open and close the drawer
//        val mActionDrawerToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open,
//                R.string.drawer_close)
//        drawer_layout!!.setDrawerListener(mActionDrawerToggle)
//        mActionDrawerToggle.syncState()
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.viewpagerLayout.mainToolbar.toolbar)
    }

    private fun setupNavigationView() {
        val toolbar = binding.viewpagerLayout.mainToolbar.toolbar
        toolbar.setNavigationIcon(R.drawable.ic_launcher)
        toolbar.setNavigationOnClickListener {
//            drawer_layout!!.openDrawer(GravityCompat.START)
//            Log.d(TAG, "onClick")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_movie, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            startActivity(Intent(this@MovieActivity, com.gooner10.settings.SettingsActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }

    public override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        val TAG = MovieActivity::class.java.simpleName
    }
}
