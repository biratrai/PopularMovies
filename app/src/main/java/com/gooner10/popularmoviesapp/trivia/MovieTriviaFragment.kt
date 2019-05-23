package com.gooner10.popularmoviesapp.trivia


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gooner10.popularmoviesapp.R


/**
 * Fragment which displays the movie Trivia
 *
 */
class MovieTriviaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_trivia, container, false)
    }


}
