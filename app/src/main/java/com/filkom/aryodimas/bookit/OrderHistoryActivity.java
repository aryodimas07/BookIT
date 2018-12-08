package com.filkom.aryodimas.bookit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.filkom.aryodimas.bookit.adapter.OrderHistoryAdapter;
import com.filkom.aryodimas.bookit.model.OrderHistoryModel;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        initializeOrderHistory();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

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
                            case R.id.nav_homepage:
                                Intent goToOrderhistory = new Intent(OrderHistoryActivity.this,MainActivity.class);
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void initializeOrderHistory(){
        ArrayList<OrderHistoryModel> orderHistoryModels = new ArrayList<>();
        orderHistoryModels.add(new OrderHistoryModel("#0001BIT","Rp. 60.000","Cinema XXI"));
        orderHistoryModels.add(new OrderHistoryModel("#0002BIT","Rp. 120.000","Cinema XXI"));
        orderHistoryModels.add(new OrderHistoryModel("#0003BIT","Rp. 80.000","Cinema XXI"));

        RecyclerView recyclerView = findViewById(R.id.rv_order_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OrderHistoryAdapter adapter = new OrderHistoryAdapter(this, orderHistoryModels);
        recyclerView.setAdapter(adapter);
    }
}
