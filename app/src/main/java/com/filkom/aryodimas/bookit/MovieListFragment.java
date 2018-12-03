package com.filkom.aryodimas.bookit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MovieListFragment extends Fragment {
    String strings[] = {"1","2","3","4","5"};

    public MovieListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new SimpleRVAdapter(strings));
        return rv;
    }

    public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
        private String[] dataSource;
        public SimpleRVAdapter(String[] data){
            dataSource = data;
        }

        @NonNull
        @Override
        public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = new TextView(viewGroup.getContext());
            SimpleViewHolder viewHolder = new SimpleViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, int i) {
            simpleViewHolder.textView.setText(dataSource[i]);
        }


        @Override
        public int getItemCount() {
            return dataSource.length;
        }
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
