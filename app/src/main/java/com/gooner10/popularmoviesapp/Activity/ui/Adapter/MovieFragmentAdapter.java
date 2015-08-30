package com.gooner10.popularmoviesapp.Activity.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gooner10.popularmoviesapp.Activity.MovieBus.MovieBus;
import com.gooner10.popularmoviesapp.Activity.MovieBus.MovieDetailBusEvent;
import com.gooner10.popularmoviesapp.Activity.domain.Model.Constants;
import com.gooner10.popularmoviesapp.Activity.domain.Model.MovieData;
import com.gooner10.popularmoviesapp.Activity.ui.Activity.MovieDetail;
import com.gooner10.popularmoviesapp.R;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Gooner10 on 8/29/15.
 */

public class MovieFragmentAdapter extends RecyclerView.Adapter<MovieFragmentAdapter.ViewHolderData> {
    public LayoutInflater layoutInflater;
    public Context mContext;
    public ArrayList<MovieData> mMovieData;

    public MovieFragmentAdapter(Context context, ArrayList<MovieData> mMovieArray) {
        layoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mMovieData = mMovieArray;
    }

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_movie_row, parent, false);
        ViewHolderData viewHolderData = new ViewHolderData(view);
        return viewHolderData;
    }

    @Override
    public void onBindViewHolder(ViewHolderData holder, final int position) {
        MovieData movie = mMovieData.get(position);
        Log.d("TAG",""+movie.getmPosterPath());
        Picasso.with(mContext)
                .load(Constants.POSTER_PATH+movie.getmPosterPath())
                .resize(250, 300)
                .placeholder(R.drawable.ic_headset)
                .error(R.drawable.ic_done)
                .into(holder.movieImageView);
        holder.titleTextView.setText(movie.getmTitle());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MovieDetail.class);
                MovieData movie = mMovieData.get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("movie_data", movie);
                intent.putExtras(bundle);
                context.startActivity(intent);

                // Send data to Bus
                Bus bus = MovieBus.getInstance();
//                MovieDetailBusEvent movieDetailBusEvent = new MovieDetailBusEvent("My Movie");
                MovieDetailBusEvent movieDetailBusEvent = new MovieDetailBusEvent(bundle);
                bus.post(movieDetailBusEvent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieData.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView movieImageView;
        public final TextView titleTextView;

        public ViewHolderData(View itemView) {
            super(itemView);
            mView = itemView;
            movieImageView = (ImageView) itemView.findViewById(R.id.imageView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }


}
