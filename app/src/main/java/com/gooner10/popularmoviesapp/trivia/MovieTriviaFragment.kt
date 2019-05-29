package com.gooner10.popularmoviesapp.trivia


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gooner10.popularmoviesapp.R
import kotlinx.android.synthetic.main.fragment_movie_trivia.view.*


/**
 * Fragment which displays the movie Trivia
 *
 */
class MovieTriviaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_trivia, container, false)
        val button = view.triviaButton
        button.setOnClickListener{ context?.startActivity(Intent(context, MainTriviaActivity::class.java)) }
        return view
    }


}
