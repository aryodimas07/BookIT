package com.filkom.aryodimas.bookit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.filkom.aryodimas.bookit.model.MovieModel;


public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener,
        NowPlayingFragment.SendMovieDataToDetail,HotMovieFragment.SendMovieDataToDetail {
    private DrawerLayout mDrawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavbar();
        setupSharedPreferences();
        getNowPlayingFragment();
        getHotMovieFragment();
    }

    private void initNavbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar !=null ){
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }
        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch (menuItem.getItemId()){
                            case R.id.nav_order_history:
                                Intent goToOrderhistory = new Intent(MainActivity.this,OrderHistoryActivity.class);
                                startActivity(goToOrderhistory);
                                break;
                        }
                        return true;
                    }
                });
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }

    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        loadToolbarColor(sharedPreferences);

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    private void loadToolbarColor(SharedPreferences sharedPreferences){
        String color = sharedPreferences.getString(getString(R.string.pref_color_key)
                ,getString(R.string.pref_color_white_value));
        if (color != null) {
            if(color.equalsIgnoreCase(this.getString(R.string.pref_color_white_value))){
                toolbar.setBackgroundColor(getResources().getColor(R.color.white_toolbar));
            } else if(color.equalsIgnoreCase(this.getString(R.string.pref_color_red_value))){
                toolbar.setBackgroundColor(getResources().getColor(R.color.red_toolbar));
            } else {
                toolbar.setBackgroundColor(getResources().getColor(R.color.eggshell_toolbar));
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals(getString(R.string.pref_color_key))){
            loadToolbarColor(sharedPreferences);
        }
    }

    private void getNowPlayingFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment1Container, new NowPlayingFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setting_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                Intent startSettingActivity = new Intent(this,SettingsActivity.class);
                startActivity(startSettingActivity);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getHotMovieFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment2Container, new HotMovieFragment()).commit();
    }

    @Override
    public void sendModelData(MovieModel movieModel) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putString("MOVIE_TITLE",movieModel.getTitle());
        args.putString("MOVIE_IMAGE",movieModel.getMoviePicUrl());
        args.putString("MOVIE_SUMMARY",movieModel.getDesc());
        movieDetailFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment1Container,movieDetailFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
