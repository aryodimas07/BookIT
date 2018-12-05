package com.filkom.aryodimas.bookit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.MovieViewHolder>{
    private Context mContext;
    private ArrayList<Movie> movieList;

    public MovieViewAdapter(Context mContext, ArrayList<Movie> orderList) {
        this.mContext = mContext;
        this.movieList = orderList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nowplaying, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        Movie movie = movieList.get(position);

        holder.ivMovie.setImageResource(movie.movPicId);
        holder.ivMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BookFilmActivity.class);
                intent.putExtra("title", movieList.get(position).title);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView ivMovie;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ivMovie = itemView.findViewById(R.id.iv_movie);
        }
    }
}
