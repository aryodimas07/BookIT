package com.filkom.aryodimas.bookit;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BookFilmActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private Button btn_buy_ticket;
    private TextView tv_title_movie,tv_book_date,tv_movie_duration;

    private static final String CHANNEL_ID ="BOOKIT_ID_NOTIFICATION_CHANNEL";
    private NotificationCompat.Builder notifyOrderBuilder;
    private NotificationManager notifyOrderManager;
    private static final int NOTIFICATION_ORDER_ID = 0;

    private Button btn_c1,btn_c2,btn_c3,btn_c4;
    private boolean booleanClick;
    private MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_film);
        createNotificationChannel();
        notifyOrderManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        initNavbar();
        initSpinner();

        tv_title_movie = findViewById(R.id.tv_movie_title_book);
        tv_book_date = findViewById(R.id.tv_date_book);
        tv_movie_duration = findViewById(R.id.tv_duration_movie_book);
        btn_buy_ticket = findViewById(R.id.btn_buy);
        btn_buy_ticket.setOnClickListener(this);

        btn_c1 = findViewById(R.id.c1);
        btn_c2 = findViewById(R.id.c2);
        btn_c3 = findViewById(R.id.c3);
        btn_c4 = findViewById(R.id.c4);

        btn_c1.setOnClickListener(this);
        btn_c2.setOnClickListener(this);
        btn_c3.setOnClickListener(this);
        btn_c4.setOnClickListener(this);

        initView();
    }

    private void initView(){
        tv_title_movie.setText(getIntent().getStringExtra("title"));

        Date now = new Date();
        String nowAsString = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).format(now);
        tv_book_date.setText(nowAsString);

        tv_movie_duration.setText(getIntent().getStringExtra("duration"));
    }

    private void initSpinner() {
        Spinner spinnerLoc = findViewById(R.id.spinner_location);

        List<String> location = new ArrayList<String>();
        location.add("Malang");
        location.add("Jakarta");
        location.add("Surabaya");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, location);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerLoc.setAdapter(dataAdapter);

        Spinner spinnerTicket = (Spinner) findViewById(R.id.spinner_tickets);

        List<String> tickets = new ArrayList<String>();
        tickets.add("1");
        tickets.add("2");
        tickets.add("3");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tickets);

        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTicket.setAdapter(dataAdapter1);

    }



    private void initNavbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar !=null ){
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_buy:
                Intent toOrderHistory = new Intent(this,OrderHistoryActivity.class);
                toOrderHistory.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,toOrderHistory,PendingIntent.FLAG_UPDATE_CURRENT);

                notifyOrderBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                        .setContentTitle(getString(R.string.order_ticket_success))
                        .setContentText(getString(R.string.complete_paymet))
                        .setSmallIcon(R.drawable.ic_ticket_confirmation)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                Notification orderNotification = notifyOrderBuilder.build();
                notifyOrderManager.notify(NOTIFICATION_ORDER_ID,orderNotification);

                startActivity(toOrderHistory);
                break;

            case R.id.c1 :
               changeSeatColor(view);
                break;
            case R.id.c2 :
                changeSeatColor(view);
                break;
            case R.id.c3 :
                changeSeatColor(view);
                break;
            case R.id.c4 :
                changeSeatColor(view);
                break;

        }
    }

    private void changeSeatColor(View view){
        if (booleanClick){
            view.setBackground(getResources().getDrawable(R.drawable.pressed_seat_button));
            booleanClick = false;
        } else {
            view.setBackground(getResources().getDrawable(R.drawable.default_button));
            booleanClick = true;
        }
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
