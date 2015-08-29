package com.gooner10.popularmoviesapp.Activity.ui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gooner10 on 8/28/15.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolderData> {

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderData holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {
        public ViewHolderData(View itemView) {
            super(itemView);
        }
    }
}
