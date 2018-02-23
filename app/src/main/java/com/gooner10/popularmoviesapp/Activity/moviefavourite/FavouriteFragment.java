package com.gooner10.popularmoviesapp.Activity.moviefavourite;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment implements MovieFavouriteContract.View {
    public static final String TAG = FavouriteFragment.class.getSimpleName();
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
        return view;
    }

    @Override
    @DebugLog
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    @DebugLog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    @DebugLog
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favoriteRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        favoriteMovieFragmentAdapter = new FavoriteMovieFragmentAdapter(getActivity(), new ArrayList<MovieData>());
        favoriteRecyclerView.setAdapter(favoriteMovieFragmentAdapter);
    }

    @Override
    @DebugLog
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new MovieFavoritePresenter(getActivity(), this);
        setData();
    }

    @Override
    @DebugLog
    public void onStart() {
        super.onStart();
    }

    @Override
    @DebugLog
    public void onResume() {
        super.onResume();
    }

    @Override
    @DebugLog
    public void onPause() {
        super.onPause();
    }

    @Override
    @DebugLog
    public void onStop() {
        super.onStop();
    }

    @Override
    @DebugLog
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    @DebugLog
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    @DebugLog
    public void onDetach() {
        super.onDetach();
    }

    @Override
    @DebugLog
    public void displayFavoriteMovie(List<MovieData> movieDataList) {
        favoriteMovieFragmentAdapter.setData(movieDataList);
    }

    public void setData() {
        Log.d(TAG, "setData: " + presenter);
        presenter.loadFavoriteMovieFromRepository();
    }

}
