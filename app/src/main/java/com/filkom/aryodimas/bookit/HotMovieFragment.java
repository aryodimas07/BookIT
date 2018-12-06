package com.filkom.aryodimas.bookit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filkom.aryodimas.bookit.adapter.MovieViewAdapter;
import com.filkom.aryodimas.bookit.model.MovieModel;

import java.util.ArrayList;

public class HotMovieFragment extends Fragment {

    ArrayList<MovieModel> movieModelList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_hotmovie, container, false);

        movieModelList = new ArrayList<>();

        initMovieList();

        RecyclerView recyclerView = v.findViewById(R.id.rv_hotmovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        MovieViewAdapter adapter = new MovieViewAdapter(getContext(), movieModelList);
        recyclerView.setAdapter(adapter);

        return v;
    }

    private void initMovieList() {
        movieModelList.add(new MovieModel("Captain Marvel", "Description", 4, "11-12-2018", getString(R.string.image_movie_1)));
        movieModelList.add(new MovieModel("Deadpool", "Description", 4, "11-12-2018", getString(R.string.image_movie_2)));
        movieModelList.add(new MovieModel("Bumblebee", "Description", 4, "11-12-2018", getString(R.string.image_movie_3)));
        movieModelList.add(new MovieModel("Aquaman", "Description", 4, "11-12-2018", getString(R.string.image_movie_4)));
        movieModelList.add(new MovieModel("Replica", "Description", 4, "11-12-2018", getString(R.string.image_movie_5)));
    }


}
