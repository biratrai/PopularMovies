package com.gooner10.popularmoviesapp.Activity.moviemain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gooner10.popularmoviesapp.Activity.data.MovieData;
import com.gooner10.popularmoviesapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Movie Fragment to display the Movie List in GridLayout
 */

public class MovieFragment extends Fragment implements MovieContract.View {
    private final String LOG_TAG = "MovieFragment";
    private MovieFragmentAdapter mMovieAdapter;
    MovieContract.UserActionsListener movieListPresenter = new MovieListPresenter(this);

    @BindView(R.id.recyclerViewMovie)
    RecyclerView mMovieRecyclerView;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        movieListPresenter.loadData();

        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        // Bind all of the view
        ButterKnife.bind(this, view);

        mMovieRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mMovieAdapter = new MovieFragmentAdapter(getActivity(), new ArrayList<MovieData>());
        mMovieRecyclerView.setAdapter(mMovieAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void displayMovieList(ArrayList<MovieData> movieDataList) {
        mMovieAdapter = new MovieFragmentAdapter(getActivity(), movieDataList);
        mMovieRecyclerView.setAdapter(mMovieAdapter);
        Log.i(LOG_TAG, "displayMovieList");
    }

}
