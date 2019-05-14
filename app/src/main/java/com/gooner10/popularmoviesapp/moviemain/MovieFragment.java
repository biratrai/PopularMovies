package com.gooner10.popularmoviesapp.moviemain;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gooner10.popularmoviesapp.R;
import com.gooner10.popularmoviesapp.data.MovieItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

/**
 * Movie Fragment to display the Movie List in GridLayout
 */

public class MovieFragment extends Fragment implements MovieContract.View {
    private final String TAG = "MovieFragment";
    private MovieFragmentAdapter movieFragmentAdapter;
˚
    @BindView(R.id.recyclerViewMovie)
    RecyclerView movierecyclerview;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        // Bind all of the view
        ButterKnife.bind(this, view);

        movierecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        movieFragmentAdapter = new MovieFragmentAdapter(getActivity(), new ArrayList<MovieItem>());
        movierecyclerview.setAdapter(movieFragmentAdapter);
        Log.i(TAG, "onCreateView movieFragmentAdapter: " + movieFragmentAdapter);
        MovieViewModel movieViewModel = ViewModelProviders.of(getActivity()).get(MovieViewModel.class);
        Log.i(TAG, "loadData getMovieDataList: " + movieViewModel.getMovieDataList());
        movieViewModel.getMovieDataList().observe(getActivity(), new Observer<List<MovieItem>>() {
            @Override
            @DebugLog
            public void onChanged(@Nullable List<MovieItem> movieDataList) {
                displayMovieList(movieDataList);
            }
        });
        return view;
    }

    @Override
    @DebugLog
    public void displayMovieList(List<MovieItem> movieDataList) {
        Log.i(TAG, "displayMovieList movieFragmentAdapter: " + movieFragmentAdapter);
        movieFragmentAdapter.setData(movieDataList);
    }

}
