package com.gooner10.popularmoviesapp.Activity.movielist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gooner10.popularmoviesapp.Activity.data.Constants;
import com.gooner10.popularmoviesapp.Activity.data.MovieData;
import com.gooner10.popularmoviesapp.Activity.movieBus.OnItemClickEvent;
import com.gooner10.popularmoviesapp.Activity.moviedetail.MovieDetail;
import com.gooner10.popularmoviesapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Fragment adapter for the MovieFragment
 */

public class MovieFragmentAdapter extends RecyclerView.Adapter<MovieFragmentAdapter.ViewHolderData> {
    private LayoutInflater layoutInflater;
    private Context mContext;
    private ArrayList<MovieData> mMovieData;

    public MovieFragmentAdapter(Context context, ArrayList<MovieData> mMovieArray) {
        layoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mMovieData = mMovieArray;
    }

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_movie_row, parent, false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderData holder, int position) {
        MovieData movie = mMovieData.get(position);
        Picasso.with(mContext)
                .load(Constants.POSTER_PATH + movie.getMoviePosterPath())
                .placeholder(R.drawable.ic_headset)
                .error(R.drawable.ic_done)
                .into(holder.movieImageView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MovieDetail.class);
                MovieData movie = mMovieData.get(holder.getAdapterPosition());
                Bundle bundle = new Bundle();
                bundle.putParcelable("movie_data", movie);
                intent.putExtras(bundle);
                context.startActivity(intent);

                // Get and Post the event
                EventBus.getDefault().postSticky(new OnItemClickEvent(bundle));
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

        public ViewHolderData(View itemView) {
            super(itemView);
            mView = itemView;
            movieImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }


}
