package com.filkom.aryodimas.bookit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HotMovieFragment extends Fragment {

    ArrayList<Movie> movieList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_hotmovie, container, false);

        movieList = new ArrayList<>();


        initMovieList();

        RecyclerView recyclerView = v.findViewById(R.id.rv_hotmovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        MovieViewAdapter adapter = new MovieViewAdapter(getContext(), movieList);
        recyclerView.setAdapter(adapter);

        return v;
    }

    private void initMovieList() {
        movieList.add(new Movie("Title", "Description", 4, "11-12-2018", R.drawable.ic_launcher_background));
        movieList.add(new Movie("Title", "Description", 4, "11-12-2018", R.drawable.ic_launcher_background));
        movieList.add(new Movie("Title", "Description", 4, "11-12-2018", R.drawable.ic_launcher_background));
        movieList.add(new Movie("Title", "Description", 4, "11-12-2018", R.drawable.ic_launcher_background));
        movieList.add(new Movie("Title", "Description", 4, "11-12-2018", R.drawable.ic_launcher_background));
    }


}
