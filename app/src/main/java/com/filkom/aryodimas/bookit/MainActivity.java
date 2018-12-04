package com.filkom.aryodimas.bookit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNowPlayingFragment();
        getHotMovieFragment();
    }

    private void getNowPlayingFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment1Container, new NowPlayingFragment()).commit();
    }

    private void getHotMovieFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment2Container, new HotMovieFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment3Container, new HotMovieFragment()).commit();
    }

}
