package com.example.prattoy.schedulo;

import android.*;
import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyService extends Service {

    public FusedLocationProviderClient fusedLocationProviderClient;
    public LocationCallback locationCallback;
    public Location location;
    private int Lola = 101;


    @Override
    public void onCreate() {
        super.onCreate();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (Build.VERSION.SDK_INT >= 26) {
            String ch = "ch1";
            NotificationChannel channel = new NotificationChannel(ch,
                    "Location",
                    NotificationManager.IMPORTANCE_DEFAULT);
            ((NotificationManager) getSystemService(this.NOTIFICATION_SERVICE)).createNotificationChannel(channel);
            Notification notification = new NotificationCompat.Builder(this, ch)
                    .setContentTitle("New")
                    .setContentText("The Service")
                    .build();
            startForeground(1, notification);
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        getLocationStatus();
        return START_NOT_STICKY;
    }

    private void getLocationStatus() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {



            locationCallback = new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {

                    location = locationResult.getLastLocation();
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference reference = database.getReference("location");
                    reference.child("0").setValue(location.getLatitude());
                    reference.child("1").setValue(location.getLongitude());

                }
            };
            LocationRequest locationRequest = LocationRequest.create();
            locationRequest.setInterval(5000);
            locationRequest.setFastestInterval(2000);
            locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, getMainLooper());
            Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        }


    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
