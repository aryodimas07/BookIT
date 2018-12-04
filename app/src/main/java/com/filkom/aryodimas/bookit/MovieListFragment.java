package com.filkom.aryodimas.bookit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.filkom.aryodimas.bookit.adapter.MovieItemAdapter;

import java.util.List;


public class MovieListFragment extends Fragment {
    String strings[] = {"1","2","3","4","5"};

    public MovieListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new GridLayoutManager(getContext(),2));
        rv.setAdapter(new MovieItemAdapter(strings));
        return rv;
    }

}
