package com.filkom.aryodimas.bookit;

import android.content.Context;
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
    private SendMovieDataToDetail movieDataToDetail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_hotmovie, container, false);

        movieModelList = new ArrayList<>();

        initMovieList();

        RecyclerView recyclerView = v.findViewById(R.id.rv_hotmovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        MovieViewAdapter adapter = new MovieViewAdapter(getContext(), movieModelList,adapterInterface);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            movieDataToDetail = (SendMovieDataToDetail) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnTextSendListener");
        }
    }

    MovieViewAdapter.MovieAdapterInterface adapterInterface = new MovieViewAdapter.MovieAdapterInterface() {
        @Override
        public void OnItemClicked(MovieModel movieModel) {
            sendModelData(movieModel);
        }
    };

    public void sendModelData(MovieModel movieModel){
        movieDataToDetail.sendModelData(movieModel);
    }

    public interface SendMovieDataToDetail{
        void sendModelData(MovieModel movieModel);
    }

    private void initMovieList() {
        movieModelList.add(new MovieModel("Captain Marvel", getString(R.string.movie_desc_dummy), 4, "11-12-2018", getString(R.string.image_movie_1)));
        movieModelList.add(new MovieModel("Deadpool", getString(R.string.movie_desc_dummy), 4, "11-12-2018", getString(R.string.image_movie_2)));
        movieModelList.add(new MovieModel("Bumblebee", getString(R.string.movie_desc_dummy), 4, "11-12-2018", getString(R.string.image_movie_3)));
        movieModelList.add(new MovieModel("Aquaman", getString(R.string.movie_desc_dummy), 4, "11-12-2018", getString(R.string.image_movie_4)));
        movieModelList.add(new MovieModel("Replica", getString(R.string.movie_desc_dummy), 4, "11-12-2018", getString(R.string.image_movie_5)));
    }


}
