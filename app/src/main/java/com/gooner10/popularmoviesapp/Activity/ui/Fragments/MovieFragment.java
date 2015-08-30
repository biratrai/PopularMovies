package com.gooner10.popularmoviesapp.Activity.ui.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gooner10.popularmoviesapp.Activity.domain.Model.MovieData;
import com.gooner10.popularmoviesapp.R;

import java.util.ArrayList;


public class MovieFragment extends Fragment {
    private static ArrayList<MovieData> mPopularDataArrayList;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Register to the bus
//        MovieBus.getInstance().register(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        EventBus.getDefault().registerSticky(this);

    }



}
