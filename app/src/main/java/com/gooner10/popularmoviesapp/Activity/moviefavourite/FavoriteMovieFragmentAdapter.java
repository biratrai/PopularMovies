package com.gooner10.popularmoviesapp.Activity.moviefavourite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gooner10.popularmoviesapp.Activity.data.MovieData;
import com.gooner10.popularmoviesapp.R;

import java.util.List;

/**
 * Adapter for Favorite Movie Fragment
 */

public class FavoriteMovieFragmentAdapter extends RecyclerView.Adapter<FavoriteMovieFragmentAdapter.MovieFavoriteViewHolder> {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<MovieData> movieData;

    public FavoriteMovieFragmentAdapter(Context context, List<MovieData> movieData) {
        this.context = context;
        this.movieData = movieData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieFavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.favorite_movie_row, parent, false);
        return new MovieFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieFavoriteViewHolder holder, int position) {
        holder.favoriteMovieText.setText(movieData.get(position).getMovieTitle());
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public void setData(List<MovieData> movieDataList) {
        this.movieData = movieDataList;
        notifyDataSetChanged();
    }

    public class MovieFavoriteViewHolder extends RecyclerView.ViewHolder {
        TextView favoriteMovieText;

        public MovieFavoriteViewHolder(View itemView) {
            super(itemView);
            favoriteMovieText = itemView.findViewById(R.id.favorite_movie_text);
        }
    }
}
