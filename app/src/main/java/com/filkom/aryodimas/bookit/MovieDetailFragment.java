package com.filkom.aryodimas.bookit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MovieDetailFragment extends Fragment {

    private TextView tv_movie_tittle,tv_movie_summary;
    private Button btn_book;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv_movie_summary = view.findViewById(R.id.tv_summary_movie);
        tv_movie_tittle = view.findViewById(R.id.tv_movie_title);
        btn_book = view.findViewById(R.id.btn_book);
    }
}
