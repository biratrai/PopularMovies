package com.gooner10.popularmoviesapp.moviemain

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gooner10.popularmoviesapp.R
import com.gooner10.popularmoviesapp.moviefavourite.FavouriteFragment
import com.gooner10.popularmoviesapp.moviesettings.SettingsActivity
import hugo.weaving.DebugLog
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.list_viewpager.*
import kotlinx.android.synthetic.main.toolbar.*

class MovieActivity : AppCompatActivity() {
    private var movieFragment: Fragment? = null
    private var favouriteFragment: FavouriteFragment? = null

    @DebugLog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        // Setup Toolbar
        setUpToolbar()

        // Setup NavigationDrawer
        setupNavigationView()

        // Setup ViewPager
        setupViewPager()

        setUpHamburger()
        // Initialize Tabs
        tabs.setupWithViewPager(viewpager)

        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false)
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        val username = sharedPref.getString(getString(R.string.pref_sort_choice), "default value")
        Log.d("TAG", username)
    }

    @DebugLog
    private fun setupViewPager() {
        Log.i(TAG, "setupViewPager: " + viewpager!!)
        val movieAdapter = MovieAdapter(supportFragmentManager)
        favouriteFragment = FavouriteFragment()
        movieFragment = MovieFragment()
        movieAdapter.addFragment(movieFragment as MovieFragment, "Popular Movies")
        movieAdapter.addFragment(favouriteFragment!!, "Favourites")
        Log.d(TAG, "setupViewPager favouriteFragment: " + favouriteFragment!!)
        viewpager!!.adapter = movieAdapter
        viewpager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
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
        val mActionDrawerToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open,
                R.string.drawer_close)
        drawer_layout!!.setDrawerListener(mActionDrawerToggle)
        mActionDrawerToggle.syncState()
    }

    private fun setUpToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
        }
    }

    private fun setupNavigationView() {
        if (toolbar != null) {
            toolbar!!.setNavigationIcon(R.drawable.ic_launcher)
            toolbar!!.setNavigationOnClickListener {
                drawer_layout!!.openDrawer(GravityCompat.START)
                Log.d(TAG, "onClick")
            }
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
            startActivity(Intent(this@MovieActivity, SettingsActivity::class.java))
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
