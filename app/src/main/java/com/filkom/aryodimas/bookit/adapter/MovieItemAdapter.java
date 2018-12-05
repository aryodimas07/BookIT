package com.filkom.aryodimas.bookit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.filkom.aryodimas.bookit.R;

public class MovieItemAdapter extends RecyclerView.Adapter<MovieItemAdapter.MovieViewHolder> {
    private String[] dataSource;

    public MovieItemAdapter(String[] data){
        dataSource = data;
    }

    @NonNull
    @Override
    public MovieItemAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = new TextView(viewGroup.getContext());
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder simpleViewHolder, int i) {


    }


    @Override
    public int getItemCount() {
        return dataSource.length;
    }


    public  class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_image_movie;
        TextView tv_title,tv_rate,tv_date_movie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_image_movie =  itemView.findViewById(R.id.iv_item_img_movie);
            tv_title =  itemView.findViewById(R.id.tv_item_title_movie);
            tv_rate =  itemView.findViewById(R.id.tv_item_vote_movie);
            tv_date_movie =  itemView.findViewById(R.id.tv_item_date_movie);
        }
    }
}
