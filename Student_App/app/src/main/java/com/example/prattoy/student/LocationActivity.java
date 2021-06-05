package com.example.prattoy.student;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {

    public Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

                /*List<Address> addresses = null;
                geocoder = new Geocoder(LocationActivity.this, Locale.getDefault());
                try {
                    addresses = geocoder.getFromLocation(la, lt, 3);
                } catch (IOException ioException) {
                    ioException.printStackTrace();

                } catch (IllegalArgumentException illegalArgumentException) {

                    illegalArgumentException.printStackTrace();
                }

                if (addresses == null || addresses.size() == 0) {

                } else {
                    Address address = addresses.get(0);
                    final ArrayList<String> addressFragments = new ArrayList<String>();

                    for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                        addressFragments.add(address.getAddressLine(i));
                    }*/
                    Intent intent = new Intent(LocationActivity.this, MapsActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
