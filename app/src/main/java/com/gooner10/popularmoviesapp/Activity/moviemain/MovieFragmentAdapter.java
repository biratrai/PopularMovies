package com.gooner10.popularmoviesapp.Activity.moviemain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import java.util.List;

import de.greenrobot.event.EventBus;
import hugo.weaving.DebugLog;

/**
 * Fragment adapter for the MovieFragment
 */

public class MovieFragmentAdapter extends RecyclerView.Adapter<MovieFragmentAdapter.ViewHolderData> {
    private static final String TAG = MovieFragmentAdapter.class.getSimpleName();
    private LayoutInflater layoutInflater;
    private Context context;
    private List<MovieData> movieData;

    @DebugLog
    public MovieFragmentAdapter(Context context, List<MovieData> mMovieArray) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.movieData = mMovieArray;
    }

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_movie_row, parent, false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderData holder, int position) {
        MovieData movie = movieData.get(position);
        Picasso.with(context)
                .load(Constants.POSTER_PATH + movie.getMoviePosterPath())
                .placeholder(R.drawable.ic_headset)
                .error(R.drawable.ic_done)
                .into(holder.movieImageView);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MovieDetail.class);
                MovieData movie = movieData.get(holder.getAdapterPosition());
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
        return movieData.size();
    }

    public void setData(List<MovieData> movieDataList) {
        this.movieData = movieDataList;
        notifyDataSetChanged();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {
        public final View view;
        public final ImageView movieImageView;

        public ViewHolderData(View itemView) {
            super(itemView);
            view = itemView;
            movieImageView = itemView.findViewById(R.id.imageView);
        }
    }


}
