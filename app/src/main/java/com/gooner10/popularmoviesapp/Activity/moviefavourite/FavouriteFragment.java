package com.gooner10.popularmoviesapp.Activity.moviefavourite;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gooner10.popularmoviesapp.Activity.data.MovieData;
import com.gooner10.popularmoviesapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment implements MovieFavouriteContract.View {

    private FavoriteMovieFragmentAdapter favoriteMovieFragmentAdapter;
    MovieFavouriteContract.Presenter presenter;

    @BindView(R.id.favourite_recyclerview)
    RecyclerView favoriteRecyclerView;

    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    @DebugLog
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        ButterKnife.bind(this, view);
        favoriteRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        favoriteMovieFragmentAdapter = new FavoriteMovieFragmentAdapter(getActivity(), new ArrayList<MovieData>());
        favoriteRecyclerView.setAdapter(favoriteMovieFragmentAdapter);

        presenter = new MovieFavoritePresenter(getActivity(), this);
        setData();

        return view;
    }

    @Override
    @DebugLog
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    @DebugLog
    public void onResume() {
        super.onResume();
    }

    @Override
    @DebugLog
    public void displayFavoriteMovie(List<MovieData> movieDataList) {
        favoriteMovieFragmentAdapter.setData(movieDataList);
    }

    public void setData() {
        presenter.loadFavoriteMovieFromRepository();
    }

}
