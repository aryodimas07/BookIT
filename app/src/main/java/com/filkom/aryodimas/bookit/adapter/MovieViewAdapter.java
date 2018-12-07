package com.filkom.aryodimas.bookit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.filkom.aryodimas.bookit.BookFilmActivity;
import com.filkom.aryodimas.bookit.R;
import com.filkom.aryodimas.bookit.model.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.MovieViewHolder>{

    private Context mContext;
    private ArrayList<MovieModel> movieModelList;

    public MovieViewAdapter(Context mContext, ArrayList<MovieModel> orderList) {
        this.mContext = mContext;
        this.movieModelList = orderList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nowplaying, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        final MovieModel movieModel = movieModelList.get(position);

        Picasso.with(mContext).load(movieModel.getMoviePicUrl()).fit().
                into(holder.ivMovie);
        holder.ivMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BookFilmActivity.class);
                intent.putExtra("title", movieModel.getTitle());
                intent.putExtra("duration", mContext.getString(R.string.movie_duration));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieModelList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView ivMovie;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ivMovie = itemView.findViewById(R.id.iv_movie);
        }
    }
}
