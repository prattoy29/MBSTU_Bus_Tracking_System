package com.example.prattoy.student;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    public Button button1;
    public Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        button1 = (Button) findViewById(R.id.sche);
        button2 = (Button) findViewById(R.id.track);


    }

    @Override
    public void onClick(View v) {
        if (v == button1) {
            Intent intent = new Intent(HomeScreen.this, ScheduleActivity.class);
            startActivity(intent);
        } else if (v == button2) {
            Intent intent = new Intent(HomeScreen.this, LocationActivity.class);
            startActivity(intent);
        }
    }
}

