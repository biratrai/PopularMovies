package com.gooner10.popularmoviesapp.moviemain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gooner10.popularmoviesapp.R;
import com.gooner10.popularmoviesapp.data.Constants;
import com.gooner10.popularmoviesapp.data.MovieItem;
import com.gooner10.popularmoviesapp.moviedetail.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import hugo.weaving.DebugLog;

/**
 * Fragment adapter for the MovieFragment
 */

public class MovieFragmentAdapter extends RecyclerView.Adapter<MovieFragmentAdapter.ViewHolderData> {
    private static final String TAG = MovieFragmentAdapter.class.getSimpleName();
    public static final String MOVIE_DATA = "movie_data";
    private LayoutInflater layoutInflater;
    private Context context;
    private List<MovieItem> movieData;

    @DebugLog
    public MovieFragmentAdapter(Context context, List<MovieItem> mMovieArray) {
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
        MovieItem movie = movieData.get(position);
        Picasso.with(context)
                .load(Constants.POSTER_PATH + movie.getPosterPath())
                .placeholder(R.drawable.ic_headset)
                .error(R.drawable.ic_done)
                .into(holder.movieImageView);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieDetailActivity.class);
                MovieItem movie = movieData.get(holder.getAdapterPosition());
                Bundle bundle = new Bundle();
                bundle.putParcelable(MOVIE_DATA, movie);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public void setData(List<MovieItem> movieDataList) {
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
